package io.canelhas.javalyzer;

import java.util.stream.Stream;

public interface ToolRunner {


    ShellOutput run( String[] s );

    record ShellOutput(int exitCode, Stream< String > stderr, Stream< String > stdout) {}


}
