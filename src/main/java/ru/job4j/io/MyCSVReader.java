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
                "targetCsvFileScanner.csv", "name");
        myCsvReader.writeCsv("name; age; birthDate; education; children;"
                + System.lineSeparator()
                + " Ivan; 30; 20.05.1991; higher; one;"
                + System.lineSeparator()
                + " Oleg; 40; 20.05.1981; average; two;"
                + System.lineSeparator()
                + " Petr; 50; 20.05.1971; professional; three;"
                + System.lineSeparator()
                + " Pavel; 100; 20.05.1921; no; five");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(myCsvReader.out))) {
            Scanner scanner = new Scanner(myCsvReader.path);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                out.write(s);
            }
            System.out.println(Arrays.toString(myCsvReader.getRowsColsNo()));
            System.out.println();
            System.out.println(Arrays.toString(myCsvReader.getRowsColsString(myCsvReader.filter)));
            System.out.println();
                //System.out.println(Arrays.toString(scanner.toString().getBytes(StandardCharsets.UTF_8)));
            BufferedReader br = new BufferedReader(new FileReader(myCsvReader.path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(myCsvReader.delimiter);
                System.out.println("Column 0 = " + cols[0] + " , Column 1 = " + cols[1]);
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
    private int[] getRowsColsNo() {
        int rows = 0;
        int cols = 0;
        String InputLine;
        try {
            Scanner scanIn = new Scanner(new BufferedReader(
                    new FileReader(this.path)));
            scanIn.useDelimiter(",");
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split(";");
                rows++;
                cols = InArray.length;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new int[] { rows, cols };
    }
    private String[] getRowsColsString(String filter) {
        String[] TargetArray = new String[100];
        int rows = 0;
        int cols = 0;
        String InputLine;
        try {
            Scanner scanIn = new Scanner(new BufferedReader(
                    new FileReader(this.path)));
            scanIn.useDelimiter(",");
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split(";");
                for (String ignored : InArray) {
                    if (InArray[rows].equals(filter)) {
                        TargetArray[rows] = InArray[rows];
                    }
                    rows++;
                }
                cols = InArray.length;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return TargetArray;
    }

}
