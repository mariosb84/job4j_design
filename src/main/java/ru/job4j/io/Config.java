package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String key;
        String value;
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            for (String x = in.readLine(); x != null; x = in.readLine()) {
                    for (int i = 0; i < x.split("=").length - 1; i++) {
                   key = x.split("=")[i];
                   value = x.split("=")[i + 1];
                       values.put(key, value);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (key == null) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}