package ru.job4j.gc.cache;

import java.io.IOException;

public class Emulator {

    public static void main(String[] args) throws IOException {
        String pathFolder = "C:/projects/job4j_design";
        String dir = "Names.txt";
        String dir2 = "Address.txt";
        String dir3 = "Addresses.txt";
        DirFileCache dirFileCache = new DirFileCache(pathFolder);
        System.out.println(dirFileCache.get(dir));
        System.out.println();
        System.out.println(dirFileCache.get(dir2));
        System.out.println();
        System.out.println(dirFileCache.get(dir3));
    }

}
