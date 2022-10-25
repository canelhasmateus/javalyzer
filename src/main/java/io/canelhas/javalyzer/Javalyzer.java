package io.canelhas.javalyzer;

import io.canelhas.javalyzer.JarSummary.InfoKinds;
import io.canelhas.javalyzer.JarSummary.JarInfo;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static io.canelhas.javalyzer.utils.FileUtils.walk;

@RequiredArgsConstructor
public class Javalyzer {
    private final Set< Path > paths;

    public Stream< JarSummary > run( Predicate< JarInfo > chooser ) {
        return run( chooser, new JarGatherer() );
    }

    public Stream< JarSummary > run( Predicate< JarInfo > chooser, Gatherer< InfoKinds >... gatherer ) {

        Stream< Path > pathStream = walk( paths ).filter( f -> {
            return f.toFile()
                    .getName()
                    .endsWith( ".jar" );
        } );

        Jdeps analyzer = Jdeps.of( pathStream, gatherer );
        return analyzer.run( chooser );
    }

}