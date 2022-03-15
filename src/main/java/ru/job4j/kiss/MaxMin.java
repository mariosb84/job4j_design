package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin  {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = x -> x > 0;
        return maxMin(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = x -> x < 0;
     return maxMin(value, comparator, predicate);
    }

     private static <T> T maxMin(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
         T result = null;
         List<T> list = new ArrayList<>(List.copyOf(value));
         for (int i = 0; i < list.size() - 1; i++) {
             T t1 = list.get(i);
             T t2 = list.get(i + 1);
             if (predicate.test(comparator.compare(t1, t2))) {
                 result = t1;
                 list.set(i + 1, result);
             } else {
                 result = t2;
             }
         }
         return result;
    }

}
