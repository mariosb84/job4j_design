package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;

public class ControlQuality {
/*
*
* Context.java
* */
    private final StrategyStorage strategyStorage;

    public ControlQuality(StrategyStorage strategyStorage) {
        this.strategyStorage = strategyStorage;
        }

        public void executeStrategyStorageFirst(List<Food> foods, Predicate<Food> p) {
        strategyStorage.add(foods, p);
        }

    public List<Food> executeStrategyStorageSecond() {
        return strategyStorage.giveAway();
        }

    public void executeStrategyStorageThird(double discount) {
        strategyStorage.addDiscount(discount);
        }

    }



