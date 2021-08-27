package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
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
        if (args.length != 4) {
            throw new IllegalArgumentException("Path is null, delimiter is null, out is null, filter is null."
                    + " Usage java -jar target/csvReader.jar -path=file.csv -delimiter=\";\"  -out=stdout -filter=name,age.");
        }
        ArgsName argsName = ArgsName.of(args);
        MyCSVReader myCsvReader = new MyCSVReader("sourceCsvFileScanner.csv", ";",
                "targetCsvFileScanner.csv", "name,age");
        myCsvReader.writeCsv("name;age;birthDate;education;children;"
                + System.lineSeparator()
                + "Ivan;30;20.05.1991;higher;one;"
                + System.lineSeparator()
                + "Oleg;40;20.05.1981;average;two;"
                + System.lineSeparator()
                + "Pavel;100;20.05.1921;no;five", myCsvReader.path);
        myCsvReader.getColumnsStrings(myCsvReader.filter);
    }
    private void getColumnsStrings(String filter) {
        StringBuilder builder = new StringBuilder();
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
                    for (l = 0; l < filterArr.length; l++) {
                        if (inArray[i].equals(filterArr[l])) {
                            writeEnable = true;
                            numberColumn.add(i);
                        }
                    }
                }
                if (writeEnable) {
                    String s = getOut(this.delimiter, numberColumn, inArray);
                    System.out.println(s);                                     // вывод в консоль
                    builder.append(s).append(System.lineSeparator());          // запись в файл
                }
            }
            writeCsv(builder.toString(), this.out);                            // запись в файл

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private String getOut(String regex, List<Integer> list, String[] array) {
        StringBuilder out = new StringBuilder();
        for (int i : list) {
            out.append(array[i]).append(regex);
        }
        return out.toString();
    }
    private void writeCsv(String s, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            out.write(s);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}