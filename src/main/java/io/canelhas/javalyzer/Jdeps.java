package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo;
import io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds;
import io.canelhas.javalyzer.ToolRunner.ParseInfo;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.Full;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.NotFound;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.PackageOnly;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.ToolWarning;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.Unknown;
import io.canelhas.javalyzer.ToolRunner.ShellOutput;
import org.apache.maven.model.ModelBase;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.withLocationInfo;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.artifactOf;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.createFrom;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.fileNameOf;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.fullPathOf;
import static io.canelhas.javalyzer.DependenciesView.increaseCount;
import static io.canelhas.javalyzer.Gatherer.enrichWith;
import static io.canelhas.javalyzer.utils.FunctionalUtils.lookupWith;
import static java.lang.System.arraycopy;
import static java.util.spi.ToolProvider.findFirst;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Jdeps {

    private final ToolRunner jdeps;
    private final String[] args;
    private final Collection<JarInfo> classPath;
    private final Map<String, JarInfo> lookup;

    public Jdeps(ToolRunner jdeps, Collection<JarInfo> jars) {

        this.classPath = jars;
        this.jdeps = jdeps;

        this.lookup = lookupWith(jars, fileNameOf());
        this.lookup.putAll(lookupWith(jars, artifactOf()));

        // TODO: 24/10/2022 parametrize?
        final List<String> args = new ArrayList<>();
        args.add("-verbose");

        args.add("--multi-release");
        args.add("base");

        args.add("--class-path");
        args.add(jars.stream()
            .map(fullPathOf())
            .distinct()
            .collect(joining(";")));

        this.args = args.toArray(new String[0]);

    }

    public static Jdeps of(Stream<Path> paths, Gatherer<InfoKinds>... gatherers) {

        final var classPath = paths.distinct()
            .map(withLocationInfo())
            .map(enrichWith(gatherers))
            .map(createFrom())
            .collect(toList());

        final var runner = (ToolRunner) (arg) -> {

            final var output = new StringWriter();
            final var std = new PrintWriter(output);
            final var err = new PrintWriter(new StringWriter());
            final var status = findFirst("jdeps").orElseThrow().run(std, err, arg);

            return new ShellOutput(
                status,
                err.toString().lines(),
                output.toString().lines());
        };

        return new Jdeps(runner, classPath);
    }

    public Stream<DependenciesView> run(Predicate<JarInfo> filter) {
        return this.classPath.stream().filter(filter).map(jar -> {

            ShellOutput shellOutput;
            {
                final var copiedArgs = new String[args.length + 1];
                arraycopy(args, 0, copiedArgs, 0, args.length);
                copiedArgs[copiedArgs.length - 1] = fullPathOf().apply(jar);

                try {
                    shellOutput = jdeps.run(copiedArgs);
                } catch (Exception e) {
                    shellOutput = new ShellOutput(0, Stream.empty(), Stream.empty());
                }
            }

            final var frequencies = new HashMap<JarInfo, Integer>();
            final var increase = increaseCount(frequencies);
            shellOutput.stdout().map(this::parseLine).forEach(info -> {

                if (info instanceof Unknown) {
                    increase.accept(null);
                } else if (info instanceof NotFound) {
                    increase.accept(null);
                } else if (info instanceof PackageOnly p) {
                    increase.accept(p.foundLookup);
                } else if (info instanceof Full f) {
                    increase.accept(f.foundLookup);
                }

            });

            final var dependencies = jar.relatedPoms()
                .stream()
                .map(ModelBase::getDependencies)
                .flatMap(Collection::stream)
                .collect(toSet());

            return DependenciesView.builder()
                .usageCount(frequencies)
                // todo produce dependencies from jar pom. the current implementation wont ever show unused dependencies.
                .dependencies(dependencies)
                .jar(jar)
                .build();

        });
    }

    private ParseInfo parseLine(String line) {

        final var split = line.split("->");
        if (split.length == 1) {
            return new ToolWarning(split[0]);
        }

        // Format is: "currentClass -> [ dependsOnClass ] dependsOnPackage"
        // The package is always at the last position.
        final var originClass = split[0].trim();
        final var dependencyInfo = split[1].trim().split("\\s+", 2);
        final var infoLength = dependencyInfo.length;

        final String destinationClass;
        final String destinationPackage;
        switch (infoLength) {
            case 1 -> {
                destinationPackage = dependencyInfo[0];
                destinationClass = "";
            }
            case 2 -> {
                destinationClass = dependencyInfo[0];
                destinationPackage = dependencyInfo[1];

            }
            default -> throw new IllegalStateException("Unexpected value: " + Arrays.toString(split));
        }

        final var jarInfo = lookup.get(destinationPackage);
        final var hasInfo = jarInfo != null;
        final var hasClass = !"".equals(destinationClass);
        final var hasPackage = !"".equals(destinationPackage);

        if (hasInfo) {
            if (hasPackage && hasClass) {
                return new Full(originClass, destinationPackage, destinationClass, jarInfo);
            } else if (hasPackage) {
                return new PackageOnly(originClass, destinationPackage, jarInfo);
            } else {
                return new Unknown(originClass, destinationPackage, destinationClass, jarInfo);
            }
        } else {
            return new NotFound(originClass, destinationPackage, destinationClass);
        }

    }

}


