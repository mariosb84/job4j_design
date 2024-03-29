package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class MyCSVReaderTest {

    @Test
    public void whenNameAndAgeToFile() {
        ArgsName argsName = ArgsName.of(new String[] {"-path=sourceCsvFileScanner", "-delimiter=;",
                "-out=targetCsvFileScanner", "-filter=name,age"});
        MyCSVReader myCsvReader = new MyCSVReader(argsName.get("path"), argsName.get("delimiter"),
                argsName.get("out"), argsName.get("filter"));
        myCsvReader.writeCsv("name;age;birthDate;education;children;"
                + System.lineSeparator()
                + "Oleg;40;20.05.1981;average;two;"
                + System.lineSeparator()
                + "Pavel;100;20.05.1921;no;five", argsName.get("path"));
        myCsvReader.getColumnsStrings();
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("out")))) {
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                list.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat((list.get(0)), is("name;age;"));
    }
}
