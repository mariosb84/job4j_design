package ru.job4j.ood.lsp.food;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
/*
*
* Context.java
* */
    private final List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
        }

    public void distribute(Food food) {
        storage.forEach(s -> s.add(food));
    }

    public void  resort() {
        List<Storage> newStorage;
        List<List<Food>> foods;
        if (this.storage != null) {
            newStorage = this.storage;
            foods = newStorage.stream().map(Storage::findAll).
                    collect(Collectors.toList());
            for (List<Food> foodOne : foods) {
                for (Food foodSecond : foodOne) {
                    distribute(foodSecond);
                 }
               }
            }
         }

    public static void main(String[] args) {
        List<Food> listOfFoods =  List.of(new Fruit("orange",
                        LocalDate.of(2022, 4, 22),
                        LocalDate.of(2022, 4, 1),
                        2.0, 0.0),
                new Fruit("banana",
                        LocalDate.of(22, 5, 4),
                        LocalDate.of(22, 4, 10), 5.0, 0.0),
                new Vegetables("potato",
                        LocalDate.of(22, 4, 4),
                        LocalDate.of(22, 3, 10), 1.0, 0.0),
                new Vegetables("tomato",
                        LocalDate.of(22, 4, 15),
                        LocalDate.of(22, 3, 30), 3.0, 0.0),
                new Meat("chicken",
                        LocalDate.of(22, 4, 11),
                        LocalDate.of(22, 4, 3), 7.0, 0.0),
                new Meat("beef",
                        LocalDate.of(22, 4, 22),
                        LocalDate.of(22, 4, 7), 50.0, 0.0)
        );
        List<Storage> storageList = (List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        ControlQuality controlQuality = new ControlQuality(storageList);
        System.out.println("add:");
        for (Food food : listOfFoods) {
            controlQuality.distribute(food);
        }
            System.out.println(storageList);
            System.out.println();
            System.out.println("resort:");
            controlQuality.resort();
            System.out.println(storageList);
            System.out.println();

      }

    }



