package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo;
import io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.utils.FileUtils.walk;

@RequiredArgsConstructor
public class Javalyzer {

    private final Set<Path> paths;

    public Stream<DependenciesView> run(Predicate<JarInfo> chooser) {
        return run(chooser, new JarGatherer());
    }

    public Stream<DependenciesView> run(Predicate<JarInfo> chooser, Gatherer<InfoKinds>... gatherer) {

        final Stream<Path> pathStream = walk(paths).filter(f -> {
            final var name = f.toFile().getName();
            return name.endsWith(".jar")
                && !name.endsWith("-sources.jar")
                && !name.endsWith("-javadoc.jar");
        });

        final Jdeps analyzer = Jdeps.of(pathStream, gatherer);
        return analyzer.run(chooser);
    }

}
