package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Dependencies.JarInfo;
import io.canelhas.javalyzer.Dependencies.JarInfo.InfoKinds;
import io.canelhas.javalyzer.ToolRunner.ParseInfo;
import io.canelhas.javalyzer.ToolRunner.ParseInfo.*;
import io.canelhas.javalyzer.ToolRunner.ShellOutput;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.spi.ToolProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.Dependencies.JarInfo.InfoKinds.withLocationInfo;
import static io.canelhas.javalyzer.Dependencies.JarInfo.createJarInfo;
import static io.canelhas.javalyzer.Dependencies.JarInfo.fullPath;
import static io.canelhas.javalyzer.Dependencies.increaseCount;
import static io.canelhas.javalyzer.Gatherer.enrichWith;
import static io.canelhas.javalyzer.utils.FunctionalUtils.lookupWith;
import static java.util.stream.Collectors.toList;

public class Jdeps {

    private final ToolRunner             jdeps;
    private final String[]               args;
    private final Collection< JarInfo >  classPath;
    private final Map< String, JarInfo > lookup;

    public Jdeps( ToolRunner jdeps, Collection< JarInfo > jars ) {

        this.classPath = jars;
        this.jdeps = jdeps;
        this.lookup = lookupWith( jars, fullPath() );

        // TODO: 24/10/2022 parametrize?
        List< String > args = new ArrayList<>();
        args.add( "-verbose" );

        args.add( "--multi-release" );
        args.add( "base" );

        args.add( "--class-path" );
        args.add( jars.stream()
                      .map( fullPath() )
                      .distinct()
                      .collect( Collectors.joining( ";" ) ) );

        this.args = args.toArray( new String[ 0 ] );


    }

    public static Jdeps of( Stream< Path > paths, Gatherer< InfoKinds >... gatherers ) {

        var classPath = paths.distinct()
                             .map( withLocationInfo() )
                             .map( enrichWith( gatherers ) )
                             .map( createJarInfo() )
                             .collect( toList() );

        ToolRunner runner = ( arg ) -> {

            StringWriter output = new StringWriter();
            PrintWriter  std    = new PrintWriter( output );
            PrintWriter  err    = new PrintWriter( new StringWriter() );

            int status = ToolProvider.findFirst( "jdeps" )
                                     .orElseThrow()
                                     .run( std, err, arg );

            return new ShellOutput( status,
                                    err.toString().lines(),
                                    output.toString().lines() );
        };


        return new Jdeps( runner, classPath );
    }


    private ParseInfo parseLine( String line ) {

        var split = line.split( "->" );
        if ( split.length == 1 ) {
            return new ToolWarning( split[ 0 ] );
        }

        // Format is: "currentClass -> [ dependsOnClass ] dependsOnPackage"
        // The package is always at the last position.
        var originClass    = split[ 0 ].trim();
        var dependencyInfo = split[ 1 ].trim().split( "\\s+" );
        int infoLength     = dependencyInfo.length;

        String destinationPackage;
        String destinationClass;
        switch ( infoLength ) {
            case 1 -> {
                destinationPackage = dependencyInfo[ 0 ];
                destinationClass = "";
            }
            case 2 -> {
                destinationClass = dependencyInfo[ 0 ];
                destinationPackage = dependencyInfo[ 1 ];
            }
            default -> throw new IllegalStateException( "Unexpected value: " + Arrays.toString( split ) );
        }

        JarInfo jarInfo;
        {

            if ( destinationPackage.endsWith( "not found" ) ) {
                return new Unknown( originClass, destinationPackage );
            }

            jarInfo = lookup.get( destinationPackage );
            if ( jarInfo == null ) {
                return new NotFound( originClass, destinationPackage );
            }
        }

        return switch ( destinationClass ) {
            case null, "" -> new PackageOnly( originClass, destinationPackage, jarInfo );
            default -> new Full( originClass, destinationPackage, destinationClass, jarInfo );
        };


    }


    public Stream< Dependencies > run( Predicate< JarInfo > filter ) {
        return this.classPath.stream().filter( filter ).map( jar -> {

            ShellOutput shellOutput;
            {
                String[] copiedArgs = new String[ args.length + 1 ];
                System.arraycopy( args, 0, copiedArgs, 0, args.length );
                copiedArgs[ copiedArgs.length - 1 ] = fullPath().apply( jar );

                shellOutput = jdeps.run( copiedArgs );
            }

            var frequencies = new HashMap< JarInfo, Integer >();
            var increase    = increaseCount( frequencies );
            shellOutput.stdout().map( this::parseLine ).forEach( info -> {

                switch ( info ) {
                    case ToolWarning __ -> {}
                    case Unknown __ -> increase.accept( null );
                    case NotFound __ -> increase.accept( null );
                    case PackageOnly p -> increase.accept( p.foundLookup );
                    case Full f -> increase.accept( f.foundLookup );
                }

            } );

            return Dependencies.builder()
                               .usageCount( frequencies )
                               // todo produce dependencies from jar pom. the current implementation wont ever show unused dependencies.
                               .dependencies( frequencies.keySet() )
                               .jar( jar )
                               .build();

        } );
    }


}


