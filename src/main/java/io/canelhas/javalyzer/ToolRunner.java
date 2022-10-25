package io.canelhas.javalyzer;

import java.util.stream.Stream;

public interface ToolRunner {

    ShellOutput run( String[] args );

    record ShellOutput(int exitCode, Stream< String > stderr, Stream< String > stdout) {}

    sealed abstract class ParseInfo {

        final static class ToolWarning extends ParseInfo {
            public final String message;

            ToolWarning( String message ) {this.message = message;}
        }

        final static class Unknown extends ParseInfo {
            public final String message;
            public final String origin;

            Unknown( String origin, String message ) {
                this.origin = origin;
                this.message = message;
            }
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

            public final String                    originClass;
            public final String               packageName;
            public final Dependencies.JarInfo foundLookup;

            PackageOnly( String originClass, String packageName, Dependencies.JarInfo foundLookup ) {
                this.originClass = originClass;
                this.packageName = packageName;
                this.foundLookup = foundLookup;
            }
        }

        final static class Full extends ParseInfo {
            public final String                    originClass;
            public final String                    className;
            public final String               packageName;
            public final Dependencies.JarInfo foundLookup;

            Full( String originClass, String packageName, String className, Dependencies.JarInfo foundLookup ) {
                this.originClass = originClass;
                this.className = className;
                this.packageName = packageName;
                this.foundLookup = foundLookup;
            }
        }

    }
}
