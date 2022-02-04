package ru.job4j.gc;

public class User {

    private int salary;
    private String name;

    public User() {
    }
    public User(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", salary, name);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
