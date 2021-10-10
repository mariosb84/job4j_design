package ru.job4j.map;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class User {

    private String name;
    private int children;
    private int birthday;

    public User(String name, int children, int birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && birthday == user.birthday
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User userOne = new User("User", 10, 5);
        User userTwo = new User("User", 10, 5);
        HashMap<User, Object> map = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        int x = (userOne.hashCode()) ^ (userOne.hashCode() >>> 16);
        int y = (userTwo.hashCode()) ^ (userTwo.hashCode() >>> 16);
        System.out.println(x);
        System.out.println(y);
        int i = (16 - 1) & x;
        int i2 = (16 - 1) & y;
        System.out.println("Индекс бакета userOne: " + i);
        System.out.println("Индекс бакета userTwo: " + i2);
        System.out.println("Размер таблицы : " + map.size());
        System.out.println("Состав таблицы : " + map.entrySet());
    }
}
