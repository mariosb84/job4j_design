package ru.job4j.io;

public class MultTable {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            for (int k = 1; k < 11; k++) {
                System.out.print(k * i + "  ");
            }
            System.out.println("");
        }
    }
    public static String out() {
        return "Test";
    }
}
