package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Gatherer.GatheredInfo;
import lombok.Builder;
import lombok.Value;
import org.apache.maven.model.Model;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.jar.Manifest;

import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.total;
import static java.util.Optional.ofNullable;

@Value
@Builder
public class DependenciesView {

    JarSummary jar;
    Set<JarSummary> dependencies;
    Map<JarSummary, Integer> usageCount;

    public record JarSummary(Optional<String> artifactId, Optional<String> groupId, Optional<String> version
    ) {

    }

    public record JarInfo(Path jarFile,
                          List<Model> relatedPoms,
                          Optional<Manifest> manifest,
                          JarSummary summary,
                          List<Path> relatedLocations) {


        public enum InfoKinds {
            LOCATIONS(),
            JARFILE(),
            MANIFEST(),
            POM(),
            VERSION(),
            ARTIFACT(),
            GROUP();

            public static Function<List<Path>, GatheredInfo<InfoKinds>> withLocationInfo() {
                return p -> GatheredInfo.of(InfoKinds.class).with(LOCATIONS, total(p));
            }
        }

    }

}
