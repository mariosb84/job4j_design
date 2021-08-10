package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private final String path;
    private final String delimiter;
    private final String out;
    private final String filter;

    public CSVReader(String path, String delimiter, String out, String filter) {
        this.path = path;
        this.delimiter = delimiter;
        this.out = out;
        this.filter = filter;
    }


    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader("sourceCsvFileScanner.csv", "; ",
                "targetCsvFileScanner.csv", "name, age");
        csvReader.writeCsv("name; age; birthDate; education; children"
                + System.lineSeparator()
                            + "Ivan; 30; 20.05.1991; higher; one"
                + System.lineSeparator()
                            + "Oleg; 40; 20.05.1981; average; two"
                + System.lineSeparator()
                            + "Petr; 50; 20.05.1971; professional; three"
                + System.lineSeparator()
                            + "Pavel; 100; 20.05.1921; no; five");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(csvReader.out))) {
            var data = csvReader.readCsv();
            var scanner = new Scanner
                    (new ByteArrayInputStream(data.getBytes()))
                    .useDelimiter(csvReader.delimiter);
            scanner.findInLine(csvReader.filter);
            while (scanner.hasNext()) {
                out.write(scanner.next() + " " + System.lineSeparator());
                //System.out.println(Arrays.toString(scanner.toString().getBytes(StandardCharsets.UTF_8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readCsv() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                builder.append(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void writeCsv(String s) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
                out.write(s);
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
