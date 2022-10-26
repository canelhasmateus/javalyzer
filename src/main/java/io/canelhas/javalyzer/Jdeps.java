package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo;
import io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds;
import io.canelhas.javalyzer.DependenciesView.JarSummary;
import io.canelhas.javalyzer.Gatherer.GatheredInfo;
import io.canelhas.javalyzer.ToolRunner.ParseInfo;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.Full;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.NotFound;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.PackageOnly;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.ToolWarning;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.Unknown;
import io.canelhas.javalyzer.ToolRunner.ShellOutput;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
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
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.jar.Manifest;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.withLocationInfo;
import static io.canelhas.javalyzer.Gatherer.enrichWithAll;
import static io.canelhas.javalyzer.utils.FunctionalUtils.lookupWithAll;
import static java.lang.System.arraycopy;
import static java.util.Optional.ofNullable;
import static java.util.spi.ToolProvider.findFirst;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Jdeps {

    private final ToolRunner jdeps;
    private final String[] args;
    private final Collection<JarInfo> classPath;
    private final Map<String, JarSummary> lookup;
    private final Map<Integer, JarSummary> summaryLookup;

    public Jdeps(ToolRunner jdeps, Collection<JarInfo> jars) {

        this.classPath = jars;
        this.jdeps = jdeps;

        this.lookup = lookupWithAll(jars, JarInfo::summary, jarName(), artifactOf());
        this.summaryLookup = lookupWithAll(jars, JarInfo::summary, summaryHash());

        // TODO: 24/10/2022 parametrize?
        final List<String> args = new ArrayList<>();
        args.add("-verbose");

        args.add("--multi-release");
        args.add("base");

        args.add("--class-path");
        args.add(jars.stream()
            .map(jarPath())
            .distinct()
            .collect(joining(";")));

        this.args = args.toArray(new String[0]);

    }

    public static Jdeps of(Stream<Path> paths, Gatherer<InfoKinds>... gatherers) {

        // TODO: 26/10/22 Generalize this, as well as infoGathering, by using an SearchIndex.
        final var collect = paths.distinct()
            .collect(groupingBy(lastName()));

        final var classPath = collect.values()
            .stream()
            .map(withLocationInfo())
            .map(enrichWithAll(gatherers))
            .map(createInfo())
            .filter(hasJar())
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

    private static Predicate<? super JarInfo> hasJar() {
        return j -> {
            final var exists = j.jarFile() != null;
            if (!exists) {
                System.out.println("No jar found for = " + j);
            }
            return exists;
        };
    }

    private static Function<Path, String> lastName() {
        return p -> {
            var s = p.getFileName().toString();

            final var extensionIdx = s.lastIndexOf(".");
            s = s.substring(0, extensionIdx);

//            final var resourceIdx = s.lastIndexOf("-") + 1;
            return s;
        };
    }

    static Consumer<JarSummary> increaseCount(HashMap<JarSummary, Integer> frequencies) {
        return key -> {
            final Integer count = frequencies.getOrDefault(key, 0);
            frequencies.put(key, count + 1);
        };
    }

    public Stream<DependenciesView> run(Predicate<JarInfo> filter) {
        return this.classPath.stream().filter(filter).map(jar -> {

            ShellOutput shellOutput;
            {
                final var copiedArgs = new String[args.length + 1];
                arraycopy(args, 0, copiedArgs, 0, args.length);
                copiedArgs[copiedArgs.length - 1] = jarPath().apply(jar);

                try {
                    shellOutput = jdeps.run(copiedArgs);
                } catch (Exception e) {
                    shellOutput = new ShellOutput(0, Stream.empty(), Stream.empty());
                }
            }

            final var frequencies = new HashMap<JarSummary, Integer>();
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
                .map(createSummary())
                .filter(Objects::nonNull)
                .collect(toSet());

            if (dependencies.isEmpty()) {
                System.out.println("dependencies is empty= " + dependencies);
            }

            return DependenciesView.builder()
                .usageCount(frequencies)
                // todo produce dependencies from jar pom. the current implementation wont ever show unused dependencies.
                .dependencies(dependencies)
                .jar(jar.summary())
                .build();

        });
    }

    public static Function<JarInfo, String> jarPath() {
        return info -> info.jarFile().toAbsolutePath().toString();
    }

    public static Function<JarInfo, String> jarName() {
        return info -> info.jarFile().getFileName().toString();
    }

    public static Function<JarInfo, String> artifactOf() {
        return info -> info.relatedPoms().stream()
            .map(Model::getArtifactId)
            .findFirst()
            .orElse(null);
    }

    private Function<Dependency, JarSummary> createSummary() {
        return d -> {

            final var hash = tripleHash(d);
            final var res = summaryLookup.get(hash);
            return res != null
                   ? res
                   : new JarSummary(
                       ofNullable(d.getArtifactId()),
                       ofNullable(d.getGroupId()),
                       ofNullable(d.getVersion()));

        };
    }

    private int tripleHash(Dependency d) {
        return tripleHash(d.getArtifactId(), d.getGroupId(), d.getVersion());
    }

    public static Function<JarInfo, Integer> summaryHash() {
        return info -> {
            final var summary = info.summary();

            final var s3 = summary.artifactId();
            final var s4 = summary.groupId();
            final var version = summary.version();
            return tripleHash(s3, s4, version);
        };
    }

    private static int tripleHash(Optional<String> s3, Optional<String> s4, Optional<String> version) {
        final var s = s3.orElse(null);
        final var s1 = s4.orElse(null);
        final var s2 = version.orElse(null);
        return tripleHash(s, s1, s2);
    }

    private static int tripleHash(String s, String s1, String s2) {
        return Objects.hash(s, s1, s2);
    }

    public static Function<GatheredInfo<InfoKinds>, JarInfo> createInfo() {

        return info -> {

            final JarSummary jarSummary;
            {
                final var version = (String) info.get(InfoKinds.VERSION).value();
                final var artifact = (String) info.get(InfoKinds.ARTIFACT).value();
                final var group = (String) info.get(InfoKinds.GROUP).value();
                jarSummary = new JarSummary(ofNullable(artifact), ofNullable(group), ofNullable(version));
            }

            final var location = (Path) info.get(InfoKinds.JARFILE).value();
            final var related = (List<Path>) info.get(InfoKinds.LOCATIONS).value();
            final var pom = (List<Model>) info.get(InfoKinds.POM).value();
            final var manifest = (Manifest) info.get(InfoKinds.MANIFEST).value();

            return new JarInfo(location, pom, ofNullable(manifest), jarSummary, related);
        };
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


