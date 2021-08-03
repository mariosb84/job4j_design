package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null, extension is null, target package is null."
                    + " Usage java -jar pack.jar -d=directory -e=class -o=file.zip.");
        }
        ArgsName argsName = ArgsName.of(args);
        Path source = Paths.get(argsName.get("d"));
        File file = new File(argsName.get("o"));
        File sourceDirectory = new File(argsName.get("d"));
        if (!sourceDirectory.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
                List<Path> sourceList = Search.search(source, p -> !p.toFile()
                .getName()
        .endsWith(argsName.get("e")));
packFiles(pathToFile(sourceList), file);
    }
    private static List<File> pathToFile(List<Path> list) {
        List<File> targetList = new ArrayList<>();
        for (Path path: list) {
            targetList.add(path.toFile());
        }
        return targetList;
    }
}
