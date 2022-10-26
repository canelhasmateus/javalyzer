package test;

import io.canelhas.javalyzer.DependenciesView;
import io.canelhas.javalyzer.DependenciesView.JarInfo;
import io.canelhas.javalyzer.ToolRunner.ShellOutput;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Optional.empty;

public interface JavalyzerTestData extends RandomBasic {

    default ShellOutput withStdout(String... s) {
        return new ShellOutput(1, Stream.empty(), Stream.of(s));
    }

    default ShellOutput withStdout(Stream<String> s) {
        return new ShellOutput(1, Stream.empty(), s);
    }

    default ShellOutput withStderr(String... s) {
        return new ShellOutput(0, Stream.of(s), Stream.empty());
    }

    default JarInfo someJarInfo(String packageName) {
        final var jar = Path.of("C:", packageName);
        final var jarSummary = new DependenciesView.JarSummary(empty(), empty(), empty());
        return new JarInfo(jar, Collections.emptyList(), empty(), jarSummary, List.of(jar));
    }

    default List<JarInfo> someClassPath(int n) {
        return IntStream.range(0, n)
            .mapToObj(__ -> someJarInfo(UUID.randomUUID().toString()))
            .collect(Collectors.toList());
    }

    default List<JarInfo> someClassPath() {
        return someClassPath(1);
    }
}
