package ru.job4j.ood.lsp.food;

import java.util.List;

public class ControlQuality {
/*
*
* Context.java
* */
    private final List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
        }

    public void distribute(Food food) {
        storage.forEach(s -> s.add(food));
    }

    }



