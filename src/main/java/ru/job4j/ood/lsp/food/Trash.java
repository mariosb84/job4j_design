package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Trash.java
 * */
public class Trash implements Storage {

    private final List<Food> trashStore = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        Predicate<Food> p = f -> (Freshness.getFreshnessOfFood(f) <= 0);
        return food != null && p.test(food);
    }

    @Override
    public boolean add(Food food) {
        if (food == null || !accept(food)) {
            return false;
        }
        this.trashStore.add(food);
        return true;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.trashStore);
    }

    @Override
    public void clear() {
    this.trashStore.clear();
    }

}
