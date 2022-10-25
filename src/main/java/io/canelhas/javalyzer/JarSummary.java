package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Gatherer.GatheredInfo;
import io.canelhas.javalyzer.mvn.pom.Model;
import lombok.Builder;
import lombok.Value;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.jar.Manifest;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.total;
import static java.util.function.UnaryOperator.identity;

@Value
@Builder
public class JarSummary {

    JarInfo         jar;
    List< JarInfo > dependencies;
    UsageStatistics usageStatistics;

    public enum InfoKinds {
        LOCATION( Path.class ),
        MANIFEST( Manifest.class ),
        POM( Model.class ),
        VERSION( String.class ),
        ARTIFACT( String.class ),
        GROUP( String.class );

        InfoKinds( Class< ? > pathClass ) {

        }

        public static GatheredInfo< InfoKinds > withLocationInfo( Path p ) {
            return GatheredInfo.of( InfoKinds.class ).with( LOCATION, total( p ) );
        }
    }

    @Builder
    @Value
    public static class JarInfo {
        Path                 location;
        Optional< Manifest > manifest;
        List< Model >        relatedPoms;

        Optional< String > version;
        Optional< String > artifactId;
        Optional< String > groupId;

        public static Collector< JarInfo, ?, Map< String, JarInfo > > partitioningByFilename( ) {
            return Collectors.toMap( JarInfo::fileName, identity(), ( a, b ) -> a );
        }

        public static JarInfo create( GatheredInfo< InfoKinds > info ) {
            return null;
        }

        public String fullPath( ) {
            return this.location.toAbsolutePath().toString();

        }

        public String fileName( ) {

            return this.location.getFileName().toString();

        }
    }

    @Builder
    @Value
    public static class UsageStatistics {
        Map< JarInfo, Integer > frequency;
    }
}
