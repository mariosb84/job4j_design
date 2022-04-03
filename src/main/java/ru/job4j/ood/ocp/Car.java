package ru.job4j.ood.ocp;

import java.util.function.BiFunction;

public class Car {
    /*
     * Чтобы расширить первый класс ,
     * поменяв условия нового расчета
     * нужно добавлять новый метод
     * */
    private static class SimpleCarPriceCalc {

        public int price(int mileage, int  price) {
            return price - mileage;
        }
    }
    /*
     * Чтобы расширить второй класс ,
     * поменяв условия нового расчета
     * нужно добавлять новую лямбду, без
     * изменения класса
     * */
    private static class AbstractCarPriceCalc<T> {

        public T abstractPrice(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }

    public static void main(String[] args) {
        SimpleCarPriceCalc car = new SimpleCarPriceCalc();
        System.out.println(car.price(300_000, 1_000_000));
        AbstractCarPriceCalc<Integer> car1 = new AbstractCarPriceCalc<>();
        int i = car1.abstractPrice((x, x1) ->
                ((x + x1)
                / (Math.min(x, x1)))
                * 1000,
                100_000, 2_000_000);
        System.out.println(i);
    }
}
