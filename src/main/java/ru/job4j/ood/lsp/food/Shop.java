package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 *  Shop.java
 * */
public class Shop implements StrategyStorage {

    private final List<Food> shopStore;

    public Shop(List<Food> shopStore) {
        this.shopStore = shopStore;
    }

    @Override
    public void add(List<Food> foods, Predicate<Food> p) {
        for (Food food : foods) {
            if (food != null && p.test(food))  {
                this.shopStore.add(food);
            }
        }
    }

    @Override
    public void addDiscount(double discount) {
        for (Food food : this.shopStore) {
            if (food != null) {
                food.setDiscount(discount);
            }
        }
    }

            @Override
            public List<Food> giveAway() {
                return this.shopStore;
            }


    }
