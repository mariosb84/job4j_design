package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 * Strategy.java
 * */

public interface Storage {

    boolean accept(Food food);

    boolean add(Food food);

    List<Food> findAll();

}
