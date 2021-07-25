package ru.job4j.io;

import java.io.*;

public class Analizy {
    boolean statusWrite = true;
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
                in.lines()
                        .filter(s -> !s.isEmpty())
                        .map(s -> s.split(" "))
                        .filter(s -> {
                            if (s.length != 2) {
                                throw new IllegalArgumentException();
                            }
                            return true;
                        })
                        .forEach(s -> {
                            try {
                                if ((s[0].substring(0, 3).contains("400") && statusWrite)
                                || (s[0].substring(0, 3).contains("500") && statusWrite)) {
                                    statusWrite = false;
                                    out.write("The server was not working :   " + s[1]
                                            + " ; ");
                                } else if (!statusWrite && !((s[0].substring(0, 3).contains("400"))
                                        || (s[0].substring(0, 3).contains("500")))) {
                                    statusWrite = true;
                                    out.write(s[1]
                                            + System.lineSeparator());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        Analizy analizy = new Analizy();
        analizy.unavailable("unavailable.csv", "testTarget");
    }
}