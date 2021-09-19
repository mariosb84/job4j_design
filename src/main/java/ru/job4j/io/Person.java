package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }
    public boolean getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public Contact getContact() {
        return contact;
    }
    public String[] getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
    public static void main(String[] args) {
        final Person person = new Person(false, 30,
                new Contact(11111, "123-45-67"),
                "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println("Json - строка:");
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":30,"
                        + "\"contact\":"
                        + "{"
                        + "\"zipCode\":\"11111\","
                        + "\"phone\":\"123-45-67\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Worker\",\"Married\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println("Модифицированная Json - строка:");
        System.out.println(personMod);
    }
}