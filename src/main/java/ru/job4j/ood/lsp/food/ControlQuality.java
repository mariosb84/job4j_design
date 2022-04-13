package ru.job4j.ood.lsp.food;

import java.util.List;

public class ControlQuality {
/*
*
* Context.java
* */
    private final StrategyStorage strategyStorage;

    public ControlQuality(StrategyStorage strategyStorage) {
        this.strategyStorage = strategyStorage;
        }

        public boolean executeStrategyStorageFirst(Food food) {
        return strategyStorage.accept(food);
        }

    public boolean executeStrategyStorageSecond(Food food) {
        return strategyStorage.add(food);
        }

    public List<Food> executeStrategyStorageThird() {
        return strategyStorage.findAll();
        }

    }



