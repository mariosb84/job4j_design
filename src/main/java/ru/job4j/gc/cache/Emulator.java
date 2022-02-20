package ru.job4j.gc.cache;

import java.io.*;
import java.util.ArrayList;

public class Emulator {

    public static void main(String[] args) {
       String dir = "Names.txt";
       Emulator emulator = new Emulator();
           DirFileCache dirFileCache = new DirFileCache(dir);
        if (!dirFileCache.cache.containsKey(dir)) {
            dirFileCache.load(emulator.readFromFile(dir));
            System.out.println("Cache is updated : ");
        } else {
            System.out.println("Cache is not updated : ");
        }
        System.out.println(dirFileCache.cache.get(dir).get());
    }

    private void writeToFile(String path) {                                  /* запись в фай*/
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
                out.write(path);
                out.write(System.lineSeparator());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private String readFromFile(String path) {                          /* чтение из файла*/
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
           for (String s = in.readLine(); s != null; s = in.readLine()) {
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.toString();
    }

}
