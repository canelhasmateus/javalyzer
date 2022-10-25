package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence;
import io.canelhas.javalyzer.Dependencies.JarInfo.InfoKinds;
import io.canelhas.javalyzer.mvn.pom.Model;
import io.canelhas.javalyzer.utils.StringUtils;
import org.apache.maven.shared.jar.JarAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

import static io.canelhas.javalyzer.Gatherer.GatheredInfo.Confidence.LOW;
import static io.canelhas.javalyzer.Dependencies.JarInfo.InfoKinds.*;

final class JarGatherer implements Gatherer< InfoKinds > {
    private static File fileLocation( GatheredInfo< InfoKinds > info ) {
        return pathLocation( info ).toFile();
    }

    private static Path pathLocation( GatheredInfo< InfoKinds > info ) {
        Confidence< Object > confidence = info.get( Dependencies.JarInfo.InfoKinds.LOCATION );
        return ( Path ) confidence.value();
    }

    public static List< Model > pomEntries( JarAnalyzer jarAnalyzer ) {
        List< JarEntry > entries = jarAnalyzer.getMavenPomEntries();
        return entries.stream().map( m -> {
            try {
                byte[] bytes = jarAnalyzer.getEntryInputStream( m ).readAllBytes();
                return StringUtils.fromXml( bytes, Model.class );
            }
            catch ( IOException e ) {
                throw new RuntimeException( e );
            }
        } ).collect( Collectors.toList() );
    }

    @Override public GatheredInfo< InfoKinds > resolve( GatheredInfo< InfoKinds > info ) {
        JarAnalyzer jarAnalyzer;
        try {
            jarAnalyzer = new JarAnalyzer( fileLocation( info ) );
        }
        catch ( IOException e ) {
            return info;
        }

        Manifest      manifest        = jarAnalyzer.getJarData().getManifest();
        List< Model > mavenPomEntries = pomEntries( jarAnalyzer );

        return info.with( MANIFEST, new Confidence<>( LOW, manifest ) )
                   .with( POM, new Confidence<>( LOW, mavenPomEntries ) )
                   // TODO: 24/10/2022
                   .with( GROUP, Confidence.none() )
                   .with( ARTIFACT, Confidence.none() )
                   .with( VERSION, Confidence.none() )
                ;
    }

    public String version( ) {

        {
//            for ( Model pomEntry : relatedPoms ) {
//                return pomEntry.getVersion();
//            }
        }

        {
//            Manifest manifest1 = manifest.orElse( null );
//            if ( manifest1 != null ) {
//                Attributes mainAttributes = manifest1.getMainAttributes();
//                String     name           = mainAttributes.getValue( "Bundle-Version" );
//                if ( name != null ) {
//                    return name;
//                }
//            }

        }
        {
//
//            String  input   = this.location.getFileName().toString();
//            Matcher matcher = Pattern.compile( "\\d+\\.\\d+([.b]\\d+)?" ).matcher( input );
//            if ( matcher.find() ) {
//                return matcher.group( 0 );
//
//            }


        }


        return null;
    }

    public String artifactId( ) {

        {
//            for ( Model pomEntry : relatedPoms ) {
//                return pomEntry.getArtifactId();
//            }
        }

        {
//
//            if ( manifest != null ) {
//
//                Attributes mainAttributes = manifest.getMainAttributes();
//                String     name           = mainAttributes.getValue( "Bundle-Name" );
//                if ( name != null ) {
//                    return name;
//                }
//            }

        }

        {
//
//            String  input   = this.location.getFileName().toString();
//            Matcher matcher = Pattern.compile( "([a-zA-Z-]+)(-\\S+?.jar)" ).matcher( input );
//            if ( matcher.matches() ) {
//                return matcher.group( 1 );
//            }

        }

//        String input = this.location.getFileName().toString();
//        return input.split( ".jar" )[ 0 ];

        return null;
    }

    public String groupId( ) {

//        for ( Model pomEntry : relatedPoms ) {
//            return pomEntry.getGroupId();
//        }

        {

//            if ( manifest != null ) {
//
//                String value = manifest.getMainAttributes().getValue( "Bundle-SymbolicName" );
//                return value;
//
//            }

        }
        return null;
    }


}
