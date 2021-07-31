package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
   private final HashSet<FileProperty> duplicate = new HashSet<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file
                .toFile()
                .length(),
                file.getFileName().toString());
if (duplicate.contains(fileProperty)) {
    System.out.println(file.toAbsolutePath());
    System.out.println("Duplicate is found!!!");
    //System.out.println("Duplicate is empty: " + duplicate.isEmpty());
} else {
    duplicate.add(fileProperty);
}
        return super.visitFile(file, attrs);
    }
}
