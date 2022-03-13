package ru.job4j.tdd.kiss;

import ru.job4j.io.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin  {
    public <T> T max(List<T> value, Comparator<T> comparator) {
          T result = null;
          List<T> list = new ArrayList<>(List.copyOf(value));
        for (int i = 0; i < list.size() - 1; i++) {
            T t1 = list.get(i);
            T t2 = list.get(i + 1);
            if (comparator.compare(t1, t2) > 0) {
                result = t1;
                list.set(i + 1, result);
            }
        }
        return result;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return null;
    }

     private static   <T> T maxMin(List<T> value, Predicate<T> predicate) {
         T result = null;
        List<T> list = new ArrayList<>(List.copyOf(value));
         for (int i = 0; i < list.size() - 1; i++) {
             T t1 = list.get(i);
             T t2 = list.get(i + 1);
            if (predicate.test()) {
                result = t1;
                list.set(i + 1, result);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> arrayList = List.of(1_000_000_000, 2, 3, 4, 55674, 6, 7, 80, 9, 2_000_000_000);
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        System.out.println(maxMin.max(arrayList, comparator));
        System.out.println(arrayList);
    }

}
