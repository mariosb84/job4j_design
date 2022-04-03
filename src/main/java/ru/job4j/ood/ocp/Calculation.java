package ru.job4j.ood.ocp;

public class Calculation {

    double a;
    double b;

    public Calculation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /*
    * Здесь, чтобы изменить метод расчета,
    * придется добавлять новый метод
    * */
    private double calculate(double a, double b) {
        return Math.cos(a) + Math.cos(b);
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation(10.0, 20.0);
        System.out.println(calculation.calculate(10.0, 20.0));
    }
}
