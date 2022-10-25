package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Gatherer.GatheredInfo;
import lombok.Builder;
import lombok.Value;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.jar.Manifest;

import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.total;
import static java.util.Optional.ofNullable;

@Value
@Builder
public class DependenciesView {

    JarInfo jar;
    Set<Dependency> dependencies;
    Map<JarInfo, Integer> usageCount;

    static Consumer<JarInfo> increaseCount(HashMap<JarInfo, Integer> frequencies) {
        return key -> {
            final Integer count = frequencies.getOrDefault(key, 0);
            frequencies.put(key, count + 1);
        };
    }

    public record JarInfo(Path location,
                          List<Model> relatedPoms,
                          Optional<Manifest> manifest,
                          Optional<String> version,
                          Optional<String> artifactId,
                          Optional<String> groupId) {

        public static Function<JarInfo, String> fullPathOf() {
            return info -> info.location.toAbsolutePath().toString();
        }

        public static Function<JarInfo, String> fileNameOf() {
            return info -> info.location.getFileName().toString();
        }

        public static Function<JarInfo, String> artifactOf() {
            return info -> info.relatedPoms.stream()
                .map(Model::getArtifactId)
                .findFirst()
                .orElse(null);
        }

        public static Function<GatheredInfo<InfoKinds>, JarInfo> createFrom() {

            return info -> {
                final Path location = (Path) info.get(InfoKinds.LOCATION).value();
                final List<Model> pom = (List<Model>) info.get(InfoKinds.POM).value();
                final Manifest manifest = (Manifest) info.get(InfoKinds.MANIFEST).value();
                final String version = (String) info.get(InfoKinds.VERSION).value();
                final String artifact = (String) info.get(InfoKinds.ARTIFACT).value();
                final String group = (String) info.get(InfoKinds.GROUP).value();

                return new JarInfo(location, pom,
                    ofNullable(manifest),
                    ofNullable(version),
                    ofNullable(artifact),
                    ofNullable(group));
            };
        }

        public enum InfoKinds {
            LOCATION(),
            MANIFEST(),
            POM(),
            VERSION(),
            ARTIFACT(),
            GROUP();

            public static Function<Path, GatheredInfo<InfoKinds>> withLocationInfo() {
                return p -> GatheredInfo.of(InfoKinds.class).with(LOCATION, total(p));
            }
        }

    }

}
