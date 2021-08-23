package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
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
        MyCSVReader myCsvReader = new MyCSVReader("sourceCsvFileScanner.csv", ";",
                "targetCsvFileScanner.csv", "name,children");
        myCsvReader.writeCsv("name;age;birthDate;education;children;"
                + System.lineSeparator()
                + "Ivan;30;20.05.1991;higher;one;"
                + System.lineSeparator()
                + "Oleg;40;20.05.1981;average;two;"
                + System.lineSeparator()
                + "Pavel;100;20.05.1921;no;five");
        System.out.println();
        myCsvReader.getColumnsStrings(myCsvReader.filter);
        System.out.println();
    }
    private void writeCsv(String s) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            out.write(s);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void getColumnsStrings(String filter) {
        ArrayList<Integer> numberColumn = new ArrayList<>();
        String inputLine;
        boolean writeEnable = false;
        int i, l;
        try {
            Scanner scanIn = new Scanner(new BufferedReader(
                    new FileReader(this.path)));
            scanIn.useDelimiter(this.delimiter);
            while (scanIn.hasNextLine()) {
                inputLine = scanIn.nextLine();
                String[] inArray = inputLine.split(this.delimiter);
                String[] filterArr = filter.split(",");
                for (i = 0; i < inArray.length; i++) {
                    for(l = 0; l < filterArr.length; l++) {
                        if (inArray[i].equals(filterArr[l])) {
                            writeEnable = true;
                            numberColumn.add(i);
                        }
                    }
                }
                if (writeEnable) {
                   // for (Integer k : numberColumn) {
                       // System.out.println("Column " + k + " = " + inArray[k]);
                        //System.out.println(inArray[k]);
                    //}
                    for (int k = 0;k < numberColumn.size();i++) {
                        System.out.println(inArray[k] + " " + inArray[k + 1]);
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private String[] getColumns(ArrayList<Integer> list, String[] arr){
        String[] arrOut = new String[list.toArray().length];
        for (Integer k : list) {
            arrOut[k] = arr[k];
        }
        return arrOut;
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

}