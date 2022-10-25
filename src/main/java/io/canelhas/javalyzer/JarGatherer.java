package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.shared.jar.JarAnalyzer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.ARTIFACT;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.GROUP;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.MANIFEST;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.POM;
import static io.canelhas.javalyzer.DependenciesView.JarInfo.InfoKinds.VERSION;
import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.someConfidence;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

final class JarGatherer implements Gatherer<InfoKinds> {

    private static File fileLocation(GatheredInfo<InfoKinds> info) {
        return pathLocation(info).toFile();
    }

    private static Path pathLocation(GatheredInfo<InfoKinds> info) {
        final var confidence = info.get(DependenciesView.JarInfo.InfoKinds.LOCATION);
        return (Path) confidence.value();
    }

    public static List<Model> pomFrom(JarAnalyzer jarAnalyzer) {
        final List<JarEntry> entries = jarAnalyzer.getMavenPomEntries();
        return entries.stream().map(m -> {
            try {
                final var bytes = jarAnalyzer.getEntryInputStream(m).readAllBytes();
                return new MavenXpp3Reader().read(new ByteArrayInputStream(bytes));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public GatheredInfo<InfoKinds> resolve(GatheredInfo<InfoKinds> info) {
        final JarAnalyzer jarAnalyzer;
        try {
            jarAnalyzer = new JarAnalyzer(fileLocation(info));
        } catch (IOException e) {
            return info;
        }

        final var manifest = manifestFrom(jarAnalyzer);
        final var pomEntries = pomFrom(jarAnalyzer);

        final var artifact = artifactIdFrom(jarAnalyzer, pomEntries, manifest);
        final var version = versionFrom(jarAnalyzer, pomEntries, manifest);
        final var groupId = groupIdFrom(jarAnalyzer, pomEntries, manifest);

        return info
            .with(MANIFEST, someConfidence(manifest))
            .with(POM, someConfidence(pomEntries))
            // TODO: 24/10/2022
            .with(GROUP, someConfidence(groupId))
            .with(ARTIFACT, someConfidence(artifact))
            .with(VERSION, someConfidence(version));
    }

    private Manifest manifestFrom(JarAnalyzer jarAnalyzer) {
        return jarAnalyzer.getJarData().getManifest();
    }

    private Optional<String> versionFrom(JarAnalyzer jarAnalyzer, List<Model> mavenPomEntries, Manifest manifest) {

        for (final var pomEntry : mavenPomEntries) {
            return ofNullable(pomEntry.getVersion());
        }

        if ( manifest != null ){
            final var mainAttributes = manifest.getMainAttributes();
            final var name = mainAttributes.getValue("Bundle-Version");
            if (name != null) {
                return ofNullable(name);
            }
        }
        else {
            System.out.println( jarAnalyzer.getFile().toString() );
        }

        final var input = jarAnalyzer.getFile().toString();
        final var matcher = Pattern.compile("\\d+\\.\\d+([.b]\\d+)?").matcher(input);
        if (matcher.find()) {
            return ofNullable(matcher.group(0));

        }

        return empty();
    }

    private Optional<String> groupIdFrom(JarAnalyzer jarAnalyzer, List<Model> mavenPomEntries, Manifest manifest) {

        for (var pomEntry : mavenPomEntries) {
            return ofNullable(pomEntry.getGroupId());
        }

        if (manifest != null) {
            var value = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
            return ofNullable(value);

        }
        return empty();
    }

    public Optional<String> artifactIdFrom(JarAnalyzer jarAnalyzer, List<Model> pomEntries, Manifest manifest) {

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

        final var input = jarAnalyzer.getFile().getName();
        final var matcher = Pattern.compile("([a-zA-Z-]+)(-\\S+?.jar)").matcher(input);
        if (matcher.matches()) {
            return ofNullable(matcher.group(1));
        }

        return empty();
    }

}
