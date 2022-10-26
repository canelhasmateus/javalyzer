package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.shared.jar.JarAnalyzer;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.ARTIFACT;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.GROUP;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.JARFILE;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.LOCATIONS;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.MANIFEST;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.POM;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.VERSION;
import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.someConfidence;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

final class JarGatherer implements Gatherer<InfoKinds> {

    @Override
    public GatheredInfo<InfoKinds> resolve(GatheredInfo<InfoKinds> info) {

        final var paths = relatedLocations(info);
        final var jarPath = jarLocation(paths);
        final var pomEntries = pomFrom(paths);

        final var basicInfo = info
            .with(JARFILE, someConfidence(jarPath))
            .with(POM, someConfidence(pomEntries));

        try {
            final var jarAnalyzer = new JarAnalyzer(jarPath.toFile());
            final var manifest = manifestFrom(jarAnalyzer);

            final var artifact = artifactIdFrom(jarPath, pomEntries, manifest);
            final var version = versionFrom(jarPath, pomEntries, manifest);
            final var groupId = groupIdFrom(jarPath, pomEntries, manifest);

            return basicInfo
                .with(MANIFEST, someConfidence(manifest))
                // TODO: 24/10/2022
                .with(GROUP, someConfidence(groupId))
                .with(ARTIFACT, someConfidence(artifact))
                .with(VERSION, someConfidence(version));
        } catch (Exception e) {
            return basicInfo;
        }
    }

    private static Path jarLocation(List<Path> paths1) {

        return paths1.stream().filter(endsWith("jar"))
            .findFirst()
            .orElse(null);
    }

    private static List<Path> relatedLocations(GatheredInfo<InfoKinds> info) {
        final var confidence = info.get(LOCATIONS);
        return (List<Path>) confidence.value();
    }

    public static List<Model> pomFrom(List<Path> relatedPaths) {

        return relatedPaths.stream().filter(endsWith("pom")).map(p -> {
            try {
                final var reader = new FileReader(p.toFile());
                return new MavenXpp3Reader().read(reader);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    private static Predicate<Path> endsWith(String end) {
        return p -> p.getFileName().toString().endsWith(end);
    }

    private Manifest manifestFrom(JarAnalyzer jarAnalyzer) {
        return jarAnalyzer.getJarData().getManifest();
    }

    private Optional<String> versionFrom(Path jarFile, List<Model> mavenPomEntries,
                                         Manifest manifest) {

        for (final var pomEntry : mavenPomEntries) {
            return ofNullable(pomEntry.getVersion());
        }

        if (manifest != null) {
            final var mainAttributes = manifest.getMainAttributes();
            final var name = mainAttributes.getValue("Bundle-Version");
            if (name != null) {
                return ofNullable(name);
            }
        } else {
            System.out.println("Could not find Manifest for " + jarFile.toString());
        }

        final var input = jarFile.toFile().toString();
        final var matcher = Pattern.compile("\\d+\\.\\d+([.b]\\d+)?").matcher(input);
        if (matcher.find()) {
            return ofNullable(matcher.group(0));

        }

        return empty();
    }

    private Optional<String> groupIdFrom(Path jarFile, List<Model> mavenPomEntries, Manifest manifest) {

        for (var pomEntry : mavenPomEntries) {
            return ofNullable(pomEntry.getGroupId());
        }

        if (manifest != null) {
            var value = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
            return ofNullable(value);

        }
        return empty();
    }

    public Optional<String> artifactIdFrom(Path jarFile, List<Model> pomEntries, Manifest manifest) {
        for (final var pomEntry : pomEntries) {
            return ofNullable(pomEntry.getArtifactId());
        }

        if (manifest != null) {

            final var mainAttributes = manifest.getMainAttributes();
            final var name = mainAttributes.getValue("Bundle-Name");
            if (name != null) {
                return ofNullable(name);
            }
        }

        final var input = jarFile.toFile().getName();
        final var matcher = Pattern.compile("([a-zA-Z-]+)(-\\S+?.jar)").matcher(input);
        if (matcher.matches()) {
            return ofNullable(matcher.group(1));
        }

        return empty();
    }

}
