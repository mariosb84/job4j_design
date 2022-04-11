package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;
/*
 *
 * Strategy.java
 * */
public interface StrategyStorage {

void add(List<Food> foods, Predicate<Food> p);

void addDiscount(double discount);

List<Food> giveAway();

}
