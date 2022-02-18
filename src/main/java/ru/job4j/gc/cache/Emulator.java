package ru.job4j.gc.cache;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Emulator {

    private  String directory;


    public static void main(String[] args) {
       String dir = "Names.txt";
           DirFileCache dirFileCache = new DirFileCache(dir);
        System.out.println(dirFileCache.cache.toString());
        //if (!Objects.equals(dirFileCache.cache.get(dir).get(), dir)) {
            if (true) {
            dirFileCache.load("123");
        } else {
            System.out.println(dirFileCache.cache.get(dir).get());
        }
        System.out.println(dirFileCache.cache.get(dir).get());
        System.out.println(dirFileCache.cache.toString());
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
