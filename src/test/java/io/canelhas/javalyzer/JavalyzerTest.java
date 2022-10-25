package io.canelhas.javalyzer;

import io.canelhas.javalyzer.JarSummary.JarInfo;
import io.canelhas.javalyzer.JarSummary.UsageStatistics;
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

        Optional< JarSummary > first = new Jdeps( runner, someClassPath() )
                                               .run( FOR_ALL )
                                               .findFirst();

        assertThat( stats( first ) ).hasValueSatisfying( m -> {
            assertThat( m ).isEmpty();
        } );
    }


    @Test
    public void shouldParseNotFounds( ) {

        ToolRunner jdeps = args -> withStdout( "class -> not found" );

        Optional< JarSummary > first = new Jdeps( jdeps, someClassPath() )
                                               .run( a -> true )
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
                       activiti-engine-5.17.0.jar -> jackson-core.jar
                       activiti-engine-5.17.0.jar -> java.base
                       activiti-engine-5.17.0.jar -> not found
                       """;

            return withStdout( s.lines() );
        };

        JarInfo jacksonCore = someJarInfo( "jackson-core.jar" );
        Optional< JarSummary > first = new Jdeps( jdeps, List.of( jacksonCore ) )
                                               .run( a -> true )
                                               .findFirst();

        assertThat( stats( first ) ).hasValueSatisfying( m -> {
            assertThat( m.get( jacksonCore ) ).isEqualTo( 1 );
            assertThat( m.get( null ) ).isEqualTo( 2 );
        } );
    }

    private static Optional< Map< JarInfo, Integer > > stats( Optional< JarSummary > first ) {

        return first.map( JarSummary::getUsageStatistics )
                    .map( UsageStatistics::getFrequency );
    }


}