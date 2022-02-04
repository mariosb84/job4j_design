package ru.job4j.gc;

public class GCOnAuto {
/*-Xmx4m -Xms4m*/
    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 2000000; i++) {
           // new User(i, "User_N_" + i);
            new User();
            System.out.println(i);
        }
        GCDemo.info();
    }
}
