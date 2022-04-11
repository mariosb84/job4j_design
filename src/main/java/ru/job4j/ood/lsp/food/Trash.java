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
    public void add(List<Food> foods, Predicate<Food> p) {
        for (Food food : foods) {
            if (food != null && p.test(food))  {
                this.trashStore.add(food);
            }
        }
    }

    @Override
    public void addDiscount(double discount) {

    }

    @Override
    public List<Food> giveAway() {
        return this.trashStore;
    }

}
