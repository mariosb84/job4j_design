package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 11; i++) {
                for (int k = 1; k < 11; k++) {
                    out.write((k * i + "  ").getBytes());
                }
               /* out.write("\n".getBytes())*/
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
