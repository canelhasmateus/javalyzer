package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Gatherer.GatheredInfo;
import io.canelhas.javalyzer.mvn.pom.Model;
import lombok.Builder;
import lombok.Value;

import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.jar.Manifest;

import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.total;

@Value
@Builder
public class Dependencies {

    JarInfo                 jar;
    Set< JarInfo >          dependencies;
    Map< JarInfo, Integer > usageCount;

    static Consumer< JarInfo > increaseCount( HashMap< JarInfo, Integer > frequencies ) {
        return key -> {
            Integer count = frequencies.getOrDefault( key, 0 );
            frequencies.put( key, count + 1 );
        };
    }


    public record JarInfo(Path location,
                          List< Model > relatedPoms,
                          Optional< Manifest > manifest,
                          Optional< String > version,
                          Optional< String > artifactId,
                          Optional< String > groupId) {

        public static Function< JarInfo, String > fullPath( ) {
            return info -> info.location.toAbsolutePath().toString();
        }

        public static Function< GatheredInfo< InfoKinds >, JarInfo > createJarInfo( ) {

            return info -> {
                Path          location = ( Path ) info.get( InfoKinds.LOCATION ).value();
                List< Model > pom      = ( List< Model > ) info.get( InfoKinds.POM ).value();
                Manifest      manifest = ( Manifest ) info.get( InfoKinds.MANIFEST ).value();
                String        version  = ( String ) info.get( InfoKinds.VERSION ).value();
                String        artifact = ( String ) info.get( InfoKinds.ARTIFACT ).value();
                String        group    = ( String ) info.get( InfoKinds.GROUP ).value();

                return new JarInfo( location, pom,
                                    Optional.ofNullable( manifest ),
                                    Optional.ofNullable( version ),
                                    Optional.ofNullable( artifact ),
                                    Optional.ofNullable( group ) );
            };
        }

        public enum InfoKinds {
            LOCATION(),
            MANIFEST(),
            POM(),
            VERSION(),
            ARTIFACT(),
            GROUP();


            public static Function< Path, GatheredInfo< InfoKinds > > withLocationInfo( ) {
                return p -> GatheredInfo.of( InfoKinds.class ).with( LOCATION, total( p ) );
            }
        }

    }


}
