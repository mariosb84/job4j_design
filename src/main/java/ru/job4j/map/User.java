package ru.job4j.map;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    //private Calendar birthday;
    private int birthday;

    //public User(String name, int children, Calendar birthday) {
    public User(String name, int children, int birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        //User userOne = new User("User", 10, Calendar.getInstance());
        //User userTwo = new User("User", 10, Calendar.getInstance());
        User userOne = new User("User", 10, 10);
        User userTwo = new User("User", 10, 10);
        Map<User, Object> map = new HashMap<>();
        //HashMap<String, Integer> map2 = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        System.out.println(map);
        System.out.println(userOne);
        System.out.println(userTwo);
    }
}
