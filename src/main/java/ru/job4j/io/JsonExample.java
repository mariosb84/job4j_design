package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;

public class JsonExample {
    private final boolean onSale;
    private final int price;
    private final String name;
    private final Car car;
    private final String[] history;

    public JsonExample(boolean onSale, int price, String name, Car car, String... history) {
        this.onSale = onSale;
        this.price = price;
        this.name = name;
        this.car = car;
        this.history = history;
    }

    @Override
    public String toString() {
        return "JsonExample {"
                + "onSale=" + onSale
                + ", price=" + price
                + ", name=" + name
                + ", car=" + car
                + ", history=" + Arrays.toString(history)
                + '}';
    }
    public static void main(String[] args) {
        final JsonExample jsonExample = new JsonExample(true, 200000,
                "chevrolet",
                new Car(2001, "black"),
                "Not broken", "One owner");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println("Json - строка:");
        System.out.println(gson.toJson(jsonExample));

        /* Модифицируем json-строку */
        final String jsonExampleJson =
                "{" + "\"onSale\":false,"
                        + "\"price\":200000,"
                        + "\"name\":chevrolet,"
                        + "\"car\":"
                        + "{"
                        + "\"yearOfManufacture\":\"2001\","
                        + "\"colour\":\"black\""
                        + "},"
                        + "\"history\":"
                        + "[\"Not broken\",\"One owner\"]"
                        + "}";
        final JsonExample jsonExampleMod = gson.fromJson(jsonExampleJson, JsonExample.class);
        System.out.println("Модифицированная Json - строка:");
        System.out.println(jsonExampleMod);
    }
}