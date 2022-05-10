package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Shop.java
 * */
public class Shop implements Storage {

    private final List<Food> shopStore = new ArrayList<>();
    private final static double DISCOUNT = 50.0;

    @Override
    public boolean accept(Food food) {
        Predicate<Food> p = f -> ((Freshness.getFreshnessOfFood(f) <= 75)
                && (Freshness.getFreshnessOfFood(f) >= 25));
        Predicate<Food> p2 = f2 -> ((Freshness.getFreshnessOfFood(f2) <= 25)
                && (Freshness.getFreshnessOfFood(f2) > 0));
            if (food != null && p.test(food)) {
                return true;
            }
            if (food != null && p2.test(food)) {
                food.setDiscount(DISCOUNT);
                return true;
            }
        return false;
    }

    @Override
    public boolean add(Food food) {
        if (food == null || !accept(food)) {
            return false;
        }
        this.shopStore.add(food);
        return true;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.shopStore);
       }

    @Override
    public void clear() {
    this.shopStore.clear();
    }

}
