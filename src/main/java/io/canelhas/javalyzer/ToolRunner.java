package io.canelhas.javalyzer;

import io.canelhas.javalyzer.DependenciesView.JarInfo;

import java.util.stream.Stream;

public interface ToolRunner {

    ShellOutput run(String[] args);

    record ShellOutput(int exitCode, Stream<String> stderr, Stream<String> stdout) {

    }

    sealed abstract class ParseInfo {

        final static class ToolWarning extends ParseInfo {

            public final String message;

            ToolWarning(String message) {
                this.message = message;
            }
        }

        final static class Unknown extends ParseInfo {

            public final String origin;
            public final String destPackage;
            public final String destClass;
            public final JarInfo info;

            Unknown(String origin, String destPackage, String destClass, JarInfo info ) {
                this.origin = origin;
                this.destPackage = destPackage;
                this.destClass = destClass;
                this.info = info;
            }
        }

        final static class NotFound extends ParseInfo {

            public final String message;
            public final String destPackage;
            public final String destClass;

            NotFound(String originClass, String destPackage, String destClass) {
                this.message = originClass;
                this.destPackage = destPackage;
                this.destClass = destClass;
            }
        }

        final static class PackageOnly extends ParseInfo {

            public final String originClass;
            public final String packageName;
            public final JarInfo foundLookup;

            PackageOnly(String originClass, String packageName, JarInfo foundLookup) {
                this.originClass = originClass;
                this.packageName = packageName;
                this.foundLookup = foundLookup;
            }
        }

        final static class Full extends ParseInfo {

            public final String originClass;
            public final String className;
            public final String packageName;
            public final JarInfo foundLookup;

            Full(String originClass, String packageName, String className, JarInfo foundLookup) {
                this.originClass = originClass;
                this.className = className;
                this.packageName = packageName;
                this.foundLookup = foundLookup;
            }
        }

    }
}
