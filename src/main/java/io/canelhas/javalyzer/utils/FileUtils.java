package io.canelhas.javalyzer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtils {

    public static boolean isJar(File f) {
        return f.getName().endsWith(".jar");
    }

    public static boolean isEar(File f) {
        return f.getName().endsWith(".ear");

    }

    public static boolean isJson(Path f) {
        return f.toFile().getName().endsWith(".json");

    }

    public static List<File> unzip(File fileZip, File destDir) {
        try {
            final ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
            return doUnzip(zis, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stream<Path> walk(Path path) {
        try {
            return Files.walk(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stream<Path> walk(Collection<Path> path) {
        return path.stream().flatMap(FileUtils::walk);
    }

    private static ArrayList<File> doUnzip(ZipInputStream zis, File destDir) throws IOException {
        final byte[] buffer = new byte[1024];
        ZipEntry zipEntry = zis.getNextEntry();
        final ArrayList<File> res = new ArrayList<>();
        while (zipEntry != null) {
            final File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                final File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // write file content
                res.add(newFile);
                final FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        return res;
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        final File destFile = new File(destinationDir, zipEntry.getName());

        final String destDirPath = destinationDir.getCanonicalPath();
        final String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    public static Stream<File> extractPackage(Path pkg, Path dest) throws IOException {

        return unzip(pkg.toFile(), dest.toFile())
            .stream()
            .filter(FileUtils::isEar)
            .map(f -> unzip(f, dest.toFile()))
            .flatMap(Collection::stream)
            .filter(FileUtils::isJar);

    }

    public static Function<Path, String> getName(String regex) {
        return f -> f.getFileName().toString().split(regex)[0];
    }

    public static <T> Function<Path, T> deserializeAs(Class<T> kind) {
        return f -> {
            try {
                final String s = Files.readString(f);
                return StringUtils.fromJson(s, kind);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void write(Path resolve, byte[] asJson) {
        try {
            Files.write(resolve, asJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
