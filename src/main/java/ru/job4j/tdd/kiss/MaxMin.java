package ru.job4j.tdd.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin  {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        for (int i = 0; i < value.size(); i++) {
            if (comparator.compare(value.get(i), value.get(i + 1)) > 0) {

            }
        }
        return null;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return null;
    }

}
