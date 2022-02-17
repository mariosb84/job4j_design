package ru.job4j.gc.cache;

import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Emulator {

    private  String directory;


    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        DirFileCache dirFileCache = new DirFileCache("Names.txt");
        dirFileCache.put("", "");
        dirFileCache.get("");
        dirFileCache.load("");
    }

    private void writeToFile(String path) {                                  /* запись в фай*/
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
                out.write(path);
                out.write(System.lineSeparator());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private List<String> readFromFile(String path) {                          /* чтение из файла*/
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
           for (String s = in.readLine(); s != null; s = in.readLine()) {
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
