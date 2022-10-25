package io.canelhas.javalyzer;

import io.canelhas.javalyzer.Dependencies.JarInfo;
import org.junit.jupiter.api.Test;
import test.JavalyzerTestData;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class JavalyzerTest implements JavalyzerTestData {

    private final Predicate< JarInfo > FOR_ALL = a -> true;

    @Test
    public void shouldParseWarnings( ) {

        ToolRunner runner = args -> withStdout( "just some warnings" );

        Optional< Dependencies > first = new Jdeps( runner, someClassPath() )
                                                 .run( FOR_ALL )
                                                 .findFirst();

        assertThat( stats( first ) ).hasValueSatisfying( m -> {
            assertThat( m ).isEmpty();
        } );
    }


    @Test
    public void shouldParseNotFounds( ) {

        ToolRunner jdeps = args -> withStdout( "class -> not found" );

        Optional< Dependencies > first = new Jdeps( jdeps, someClassPath() )
                                                 .run( FOR_ALL )
                                                 .findFirst();

        assertThat( stats( first ) ).hasValueSatisfying( m -> {
            assertThat( m.get( null ) ).isEqualTo( 1 );
        } );
    }

    @Test
    public void shouldParseEverything( ) {


        ToolRunner jdeps = args -> {
            String s = """
                       Warning: split package: netscape.javascript jrt:/jdk.jsobject
                       Warning: split package: org.w3c.dom jrt:/java.xml
                       Warning: split package: org.w3c.dom.events jrt:/java.xml
                       activiti-engine-5.17.0.jar -> C:\\jackson-core.jar
                       activiti-engine-5.17.0.jar -> java.base
                       activiti-engine-5.17.0.jar -> not found
                       """;

            return withStdout( s.lines() );
        };

        var jacksonCore = someJarInfo( "jackson-core.jar" );
        var first = new Jdeps( jdeps, List.of( jacksonCore ) )
                            .run( FOR_ALL )
                            .findFirst();

        assertThat( stats( first ) ).hasValueSatisfying( m -> {
            assertThat( m.get( jacksonCore ) ).isEqualTo( 1 );
            assertThat( m.get( null ) ).isEqualTo( 2 );
        } );
    }

    private static Optional< Map< JarInfo, Integer > > stats( Optional< Dependencies > first ) {
        return first.map( Dependencies::getUsageCount );
    }


}