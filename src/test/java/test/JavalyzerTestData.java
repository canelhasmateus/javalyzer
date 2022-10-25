package test;

import io.canelhas.javalyzer.JarSummary;
import io.canelhas.javalyzer.ToolRunner;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public interface JavalyzerTestData extends RandomBasic {
    default ToolRunner.ShellOutput withStdout( String... s ) {
        return new ToolRunner.ShellOutput( 1, Stream.empty(), Stream.of( s ) );
    }

    default ToolRunner.ShellOutput withStdout( Stream< String > s ) {
        return new ToolRunner.ShellOutput( 1, Stream.empty(), s );
    }

    default ToolRunner.ShellOutput withStderr( String... s ) {
        return new ToolRunner.ShellOutput( 0, Stream.of( s ), Stream.empty() );
    }

    default JarSummary.JarInfo someJarInfo( String packageName ) {
        return someJarInfo( packageName, "0.0.0" );
    }

    private static JarSummary.JarInfo someJarInfo( String packageName, String version ) {
        return JarSummary.JarInfo.builder()
                                 .location( Path.of( packageName ) )
                                 .version( ofNullable( version ) )
                                 .build();
    }

    default List< JarSummary.JarInfo > someClassPath( int n ) {
        return IntStream.range( 0, n )
                        .mapToObj( __ -> someJarInfo( UUID.randomUUID().toString(), "0.0.0" ) )
                        .collect( Collectors.toList() );
    }

    default List< JarSummary.JarInfo > someClassPath( ) {
        return someClassPath( 1 );
    }
}
