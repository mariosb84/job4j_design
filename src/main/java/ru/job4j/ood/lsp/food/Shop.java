package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Shop.java
 * */
public class Shop implements StrategyStorage {

    private final List<Food> shopStore;
    private final double discount;

    public Shop(List<Food> shopStore, double discount) {
        this.shopStore = shopStore;
        this.discount = discount;
    }

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
                food.setDiscount(this.discount);
                return true;
            }
        return false;
    }

    @Override
    public boolean add(Food food) {
        if (food != null && accept(food)) {
            this.shopStore.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(this.shopStore);
       }

    }
