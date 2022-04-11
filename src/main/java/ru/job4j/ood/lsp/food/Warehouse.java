package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Warehouse.java
 * */
public class Warehouse implements StrategyStorage {

    private final List<Food> warehouseStore;

    public Warehouse(List<Food> warehouseStore) {
        this.warehouseStore = warehouseStore;
    }

    @Override
    public void add(List<Food> foods, Predicate<Food> p) {
        for (Food food : foods) {
           if (food != null && p.test(food))  {
               this.warehouseStore.add(food);
           }
        }
    }

    @Override
    public void addDiscount(double discount) {

    }

    @Override
    public List<Food> giveAway() {
        return this.warehouseStore;
    }

}
