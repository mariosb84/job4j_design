package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

        private void parse(String[] args) {
        /* TODO parse args to values. */
        Arrays.stream(args)
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(1))
                .map(s -> s.split("="))
                .filter(s -> {
                    if (s.length != 2) {
                        throw new IllegalArgumentException();
                    }
                    return true;
                })
                .forEach(s -> values.put(s[0], s[1]));
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        if (args.length == 0) {
            throw new IllegalArgumentException("Args length == 0!!!");
        }
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        System.out.println(jvm.get("encoding"));
        System.out.println();
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
        System.out.println(zip.get("encoding"));
        System.out.println();
        ArgsName zipNull = ArgsName.of(new String[] {});
        System.out.println(zipNull.get("out"));
        System.out.println(zipNull.get("encoding"));
    }
}
