package ru.job4j.io;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MyCSVReader {
    private final String path;
    private final String delimiter;
    private final String out;
    private final String filter;

    public MyCSVReader(String path, String delimiter, String out, String filter) {
        this.path = path;
        this.delimiter = delimiter;
        this.out = out;
        this.filter = filter;
    }


    public static void main(String[] args) {
        MyCSVReader myCsvReader = new MyCSVReader("sourceCsvFileScanner.csv", "; ",
                "targetCsvFileScanner.csv", "name, age");
        myCsvReader.writeCsv("name; age; birthDate; education; children;"
                + System.lineSeparator()
                + "Ivan; 30; 20.05.1991; higher; one;"
                + System.lineSeparator()
                + "Oleg; 40; 20.05.1981; average; two;"
                + System.lineSeparator()
                + "Petr; 50; 20.05.1971; professional; three;"
                + System.lineSeparator()
                + "Pavel; 100; 20.05.1921; no; five");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(myCsvReader.out))) {
            var data = myCsvReader.readCsv();
            Scanner scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
            .useDelimiter(myCsvReader.delimiter);
            String[] nextLine = new String[100];
            int count = 0;
            while (scanner.hasNext()) {
                if (scanner.next().endsWith(";"+"")) {
                    out.write(System.lineSeparator());
                }
                //out.write(scanner.next() + " " + System.lineSeparator());
                out.write(Arrays.toString(new String[]{nextLine[count] = scanner.next()})
                        + " ");
                count++;
                //System.out.println(Arrays.toString(scanner.toString().getBytes(StandardCharsets.UTF_8)));
            }
            CSVReader reader = new CSVReader(new FileReader(myCsvReader.path), ',' , '"' , 1);
            //Read CSV line by line and use the string array as you want
            String[] nextLine2;
            while ((nextLine2 = reader.readNext()) != null) {
                    System.out.println(Arrays.toString(nextLine2));
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
