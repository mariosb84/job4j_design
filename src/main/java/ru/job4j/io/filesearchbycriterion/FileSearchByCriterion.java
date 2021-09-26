package ru.job4j.io.filesearchbycriterion;

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import static ru.job4j.io.Search.search;

public class FileSearchByCriterion {
    private final String directory;
    private final String fileName;
    private final String searchType;
    private final String fileWrite;

    public FileSearchByCriterion(String directory, String fileName, String searchType, String fileWrite) {
        this.directory = directory;
        this.fileName = fileName;
        this.searchType = searchType;
        this.fileWrite = fileWrite;
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Directory is null, fileName is null, searchType is null, fileWrite is null."
                    + " Usage java -jar target/fileSearchByCriterion.jar -d=directory -n=fileName -t=searchType -o=fileWrite.");
        }
        ArgsName argsName = ArgsName.of(args);
        FileSearchByCriterion fileSearchByCriterion = new FileSearchByCriterion(argsName.get("d"), argsName.get("n"),
                argsName.get("t"), argsName.get("o"));
        Path start = Paths.get(argsName.get("d"));
        List<Path> result = search(start, fileSearchByCriterion.searchChoice(argsName.get("n")));
        fileSearchByCriterion.writeToFile(result, argsName.get("o"));
    }
    private void writeToFile(List<Path> target, String path) {                                  // запись в файл
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (Path p : target) {
                out.write(String.valueOf(p));
                out.write(System.lineSeparator());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private Predicate<Path> searchChoice(String s) {
        Predicate<Path> result = null;
       if (this.searchType.equals("name")) {
        result = p -> p.toFile()
                .getName()
                .contains(s);
       }
        if (this.searchType.equals("mask")) {
            result = p -> p.toFile()
                    .getName()
                    .endsWith(s.substring(1));
        }
        return result;
    }
}
