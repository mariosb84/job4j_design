package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Warehouse.java
 * */
public class Warehouse implements Storage {

    private final List<Food> warehouseStore = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        Predicate<Food> p = f -> (Freshness.getFreshnessOfFood(f) > 75);
        return food != null && p.test(food);
    }

    @Override
    public boolean add(Food food) {
           if (food == null || !accept(food)) {
               return false;
           }
        this.warehouseStore.add(food);
        return true;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.warehouseStore);
    }

    @Override
    public void clear() {
    this.warehouseStore.clear();
    }

}
