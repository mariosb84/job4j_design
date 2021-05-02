package ru.job4j.map;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User userOne = new User("User", 10, Calendar.getInstance());
        User userTwo = new User("User", 10, Calendar.getInstance());
        Map<User, Object> map = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        System.out.println(userOne.hashCode());
        System.out.println(userTwo.hashCode());
        System.out.println(map.get(userOne));
        System.out.println(map.get(userTwo));
        System.out.println(map.size());
        System.out.println(map.entrySet());
    }
}
