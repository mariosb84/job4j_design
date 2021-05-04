package ru.job4j.map;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
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
        //Calendar date = new GregorianCalendar(1990, 1, 2);
        //date.get(1);
        User userOne = new User("User", 10, Calendar.getInstance());
        User userTwo = new User("User", 10, Calendar.getInstance());
        HashMap<User, Object> map = new HashMap<>();
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
