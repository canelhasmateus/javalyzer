package io.canelhas.javalyzer;

import io.canelhas.javalyzer.JarSummary.InfoKinds;
import io.canelhas.javalyzer.JarSummary.JarInfo;
import io.canelhas.javalyzer.JarSummary.UsageStatistics;
import io.canelhas.javalyzer.ParseInfo.Full;
import io.canelhas.javalyzer.ParseInfo.NotFound;
import io.canelhas.javalyzer.ParseInfo.PackageOnly;
import io.canelhas.javalyzer.ToolRunner.ShellOutput;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.spi.ToolProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.Gatherer.resolveWith;
import static io.canelhas.javalyzer.utils.FunctionalUtils.lookupWith;

public class Jdeps {

    private final ToolRunner             jdeps;
    private final String[]               args;
    private final Collection< JarInfo >  classPath;
    private final Map< String, JarInfo > lookup;

    public Jdeps( ToolRunner jdeps, Collection< JarInfo > jars ) {
        List< String > args = new ArrayList<>();
        // TODO: 24/10/2022 possibly parametrizable
        args.add( "-verbose" );
        args.add( "--multi-release" );
        args.add( "base" );


        String classPath = jars.stream()
                               .map( JarInfo::fullPath )
                               .distinct()
                               .collect( Collectors.joining( ";" ) );

        args.add( "--class-path" );
        args.add( classPath );

        // Last parameter is the jar we want to analyze - We'll substitute this later.
        args.add( "" );

        this.lookup = lookupWith( jars, JarInfo::fileName );
        this.args = args.toArray( new String[ 0 ] );
        this.classPath = jars;
        this.jdeps = jdeps;
    }

    public static Jdeps of( Collection< Path > paths, Gatherer< InfoKinds >... gatherer ) {
        return of( paths.stream(), gatherer );
    }

    public static Jdeps of( Stream< Path > paths, Gatherer< InfoKinds >... gatherers ) {

        var classPath = paths.distinct()
                             .map( InfoKinds::withLocationInfo )
                             .map( resolveWith( gatherers ) )
                             .map( JarInfo::create )
                             .collect( Collectors.toList() );

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


    private JarSummary buildContext( JarInfo jar ) {

        ShellOutput shellOutput;
        {
            String[] copiedArgs = new String[ args.length ];
            System.arraycopy( args, 0, copiedArgs, 0, args.length );
            copiedArgs[ copiedArgs.length - 1 ] = jar.getLocation().toAbsolutePath().toString();
            shellOutput = jdeps.run( copiedArgs );
        }

        UsageStatistics usageStatistics = gatherStatistics( shellOutput );
        // todo analyze gradle / maven dependencies and produce direct dependencies
        return JarSummary.builder()
                         .usageStatistics( usageStatistics )
                         .dependencies( null )
                         .jar( jar )
                         .build();

    }

    private ParseInfo parseLine( String line ) {

        var split = line.split( "->" );
        if ( split.length == 1 ) {
            return new ParseInfo.ToolWarning( split[ 0 ] );
        }

        // Format is: "currentClass -> [ dependsOnClass ] dependsOnPackage"
        // The package is always at the last position.
        var originClass    = split[ 0 ].trim();
        var dependencyInfo = split[ 1 ].trim().split( "\\s+" );

        var lastEntry = dependencyInfo[ dependencyInfo.length - 1 ];
        if ( lastEntry.endsWith( "not found" ) ) {
            return new NotFound( originClass, lastEntry );
        }

        String  destinationClass;
        String  destinationPackage;
        JarInfo jarInfo;
        return switch ( dependencyInfo.length ) {

            case 1 -> {
                destinationPackage = dependencyInfo[ 0 ];
                jarInfo = lookup.get( destinationPackage );
                yield new PackageOnly( originClass, destinationPackage, jarInfo );
            }

            case 2 -> {
                destinationClass = dependencyInfo[ 0 ];
                    destinationPackage = dependencyInfo[ 1 ];
                jarInfo = lookup.get( destinationPackage );
                yield new Full( originClass, originClass, destinationClass, jarInfo );
            }

            default -> throw new IllegalStateException( "Unexpected value: " + Arrays.toString( split ) );
        };


    }

    private UsageStatistics gatherStatistics( ShellOutput output ) {

        HashMap< JarInfo, Integer > frequencies = new HashMap<>();

        output.stdout()
              .map( this::parseLine )
              .forEach( info -> {
                  switch ( info ) {
                      case NotFound n -> {
                          Integer count = frequencies.getOrDefault( null, 0 );
                          frequencies.put( null, count + 1 );
                      }
                      case PackageOnly p -> {
                          Integer count = frequencies.getOrDefault( p.foundLookup, 0 );
                          frequencies.put( p.foundLookup, count + 1 );
                      }
                      case Full f -> {
                          Integer count = frequencies.getOrDefault( f.foundLookup, 0 );
                          frequencies.put( f.foundLookup, count + 1 );
                      }
                      default -> {}
                  }
              } );

        return UsageStatistics.builder()
                              .frequency( frequencies )
                              .build();
    }

    public Stream< JarSummary > run( Predicate< JarInfo > filter ) {
        return this.classPath.stream()
                             .filter( filter )
                             .map( this::buildContext );
    }


}


sealed class ParseInfo {

    final static class ToolWarning extends ParseInfo {
        public final String message;

        ToolWarning( String message ) {this.message = message;}
    }

    final static class NotFound extends ParseInfo {
        public final String message;
        public final String origin;

        NotFound( String origin, String message ) {
            this.origin = origin;
            this.message = message;
        }
    }

    final static class PackageOnly extends ParseInfo {

        public final String  originClass;
        public final String  packageName;
        public final JarInfo foundLookup;

        PackageOnly( String originClass, String packageName, JarInfo foundLookup ) {
            this.originClass = originClass;
            this.packageName = packageName;
            this.foundLookup = foundLookup;
        }
    }

    final static class Full extends ParseInfo {
        public final String  originClass;
        public final String  className;
        public final String  packageName;
        public final JarInfo foundLookup;

        Full( String originClass, String className, String packageName, JarInfo foundLookup ) {
            this.originClass = originClass;
            this.className = className;
            this.packageName = packageName;
            this.foundLookup = foundLookup;
        }
    }

}
