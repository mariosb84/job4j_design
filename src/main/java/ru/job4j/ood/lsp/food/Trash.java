package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Trash.java
 * */
public class Trash implements StrategyStorage {

    private final List<Food> trashStore;

    public Trash(List<Food> trashStore) {
        this.trashStore = trashStore;
    }

    @Override
    public boolean accept(Food food) {
        Predicate<Food> p = f -> (Freshness.getFreshnessOfFood(f) <= 0);
        return food != null && p.test(food);
    }

    @Override
    public boolean add(Food food) {
        if (food != null && accept(food)) {
            this.trashStore.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.trashStore);
    }

}
