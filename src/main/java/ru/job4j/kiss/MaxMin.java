package ru.job4j.kiss;

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
          T result = value.get(0);
         for (int i = 0; i <= value.size() - 1; i++) {
             T t = value.get(i);
             if (predicate.test(comparator.compare(t, result))) {
                 result = t;
             }
         }
         return result;
    }

}
