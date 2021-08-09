package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private final String path;
    private final String delimiter;
    private final String out;
    private final String[] filter;

    public CSVReader(String path, String delimiter, String out, String[] filter) {
        this.path = path;
        this.delimiter = delimiter;
        this.out = out;
        this.filter = filter;
    }


    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader("sourceCsvFileScanner.csv", ",",
                "targetCsvFileScanner.csv", new String[]{"name, age"});
        try (PrintWriter out = new PrintWriter(new FileOutputStream(csvReader.path))) {
            out.println("name, age, birthDate, education, children");
        } catch (Exception e) {
            e.printStackTrace();
        }
        var data = csvReader.readPhrases();
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter(csvReader.delimiter);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
    private String[] readPhrases() {
        String[] list = new String[100];
        int i = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (String s = in.readLine(); s != null || i < list.length; s = in.readLine(), i++) {
                list[i] = s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
