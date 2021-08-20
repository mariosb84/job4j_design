package ru.job4j.io;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                /*+ " Petr; 50; 20.05.1971; professional; three;"
                + System.lineSeparator()*/
                + " Pavel; 100; 20.05.1921; no; five");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(myCsvReader.out))) {
            Scanner scanner = new Scanner(myCsvReader.path);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                out.write(s);
            }
            //System.out.println(Arrays.toString(myCsvReader.getColumnsStringsNo()));
            System.out.println();
            myCsvReader.getColumnsStringsString(myCsvReader.filter);
            System.out.println();
            //System.out.println(Arrays.toString(scanner.toString().getBytes(StandardCharsets.UTF_8)));
            /*BufferedReader br = new BufferedReader(new FileReader(myCsvReader.path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(myCsvReader.delimiter);
                System.out.println("Column 0 = " + cols[0] + " , Column 1 = " + cols[1]);
            }*/
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
    private int[] getColumnsStringsNo() {
        int columns = 0;
        int strings = 0;
        String inputLine;
        try {
            Scanner scanIn = new Scanner(new BufferedReader(
                    new FileReader(this.path)));
            scanIn.useDelimiter(",");
            while (scanIn.hasNextLine()) {
                inputLine = scanIn.nextLine();
                String[] inArray = inputLine.split(";");
                columns++;
                strings = inArray.length;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new int[] {columns, strings };
    }
    private void getColumnsStringsString(String filter) {
        String inputLine;
        boolean writeEnable = false;
        int i;
        try {
            Scanner scanIn = new Scanner(new BufferedReader(
                    new FileReader(this.path)));
            scanIn.useDelimiter(",");
            while (scanIn.hasNextLine()) {
                inputLine = scanIn.nextLine();
                String[] inArray = inputLine.split(this.delimiter);
                for (i = 0; i < inArray.length - 1; i++) {
                    if (writeEnable = inArray[i].equals(filter)){
                        break;
                    }
                }
                if (writeEnable){
                    System.out.println("Column " + i + " = " + inArray[i]);
                }
                System.out.println(writeEnable);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
