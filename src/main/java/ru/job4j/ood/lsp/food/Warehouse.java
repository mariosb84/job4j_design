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
    public boolean accept(Food food) {
        Predicate<Food> p = f -> (Freshness.getFreshnessOfFood(f) > 75);
        return food != null && p.test(food);
    }

    @Override
    public boolean add(Food food) {
           if (food != null && accept(food)) {
               this.warehouseStore.add(food);
               return true;
           }
        return false;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.warehouseStore);
    }

}
