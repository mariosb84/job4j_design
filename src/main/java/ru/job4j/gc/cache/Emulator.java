package ru.job4j.gc.cache;

import java.io.IOException;

public class Emulator {

    public static void main(String[] args) throws IOException {
        String pathFolder = "C:/projects/job4j_design";
        String dir = "Names.txt";
        String dir2 = "Address.txt";
        DirFileCache dirFileCache = new DirFileCache(pathFolder);
        System.out.println("Cache before reading and put:");
        System.out.println(dirFileCache.cache.toString());
        System.out.println("size: " + dirFileCache.cache.size());
        System.out.println();
        System.out.println("Cache after reading and put:");
        System.out.println();
        System.out.println(dirFileCache.load(dir));
        System.out.println();
        System.out.println(dirFileCache.cache.toString());
        System.out.println("size: " + dirFileCache.cache.size());
        System.out.println();
        System.out.println("Cache after reading and put:");
        System.out.println();
        System.out.println(dirFileCache.load(dir2));
        System.out.println();
        System.out.println(dirFileCache.cache.toString());
        System.out.println("size: " + dirFileCache.cache.size());
        System.out.println();

    }

}
