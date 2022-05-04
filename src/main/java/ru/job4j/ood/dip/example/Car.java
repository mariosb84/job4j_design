package ru.job4j.ood.dip.example;

public class Car {

    private String fuel;

    public Car(String fuel) {
        this.fuel = fuel;
    }
    /*
         Класс Car , представляющий заправку автомобилей, использует для заправки класс FillTheCar .
         При подобном определении класс Car зависит от класса FillTheCar. Более того
         мы жестко определили, что заправить автомобиль можно только  бензином с помощью класса FillTheCar.
         Другие же варианты, например, электромобили - все это в данном случае исключено.
         Абстракция заправки автомобилей не отделена от деталей класса FillTheCar.
         Все это является нарушением принципа инверсии зависимостей.
       * */
    public boolean fill(FillTheCar fill) {
return fill.fillByGasoline(60);
    }
}

class FillTheCar {

    public boolean fillByGasoline(int tankCapacity) {
        return tankCapacity <= 80;
    }
}
