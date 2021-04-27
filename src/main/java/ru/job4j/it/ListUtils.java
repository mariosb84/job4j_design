package ru.job4j.it;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }

    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            //if (!filter.test(i.next())) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
             T find = i.next();
            /*for (T t : elements) {
                if (find == t) {
                    i.remove();
                }
            }*/
            if (elements.contains(find)) {
                 i.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 9, 10));
        ListUtils.addBefore(input, 1, 1);
        ListUtils.addAfter(input, 2, 3);
        ListUtils.addBefore(input, 5, 5);
        ListUtils.addAfter(input, 6, 7);
        System.out.println(input);
        Predicate<Integer> moreTwo = x -> x >= 5;
        ListUtils.removeIf(input, moreTwo);
        System.out.println(input);
        Predicate<Integer> replaceToTen = x -> x < 5;
        ListUtils.replaceIf(input, replaceToTen, 10);
        System.out.println(input);
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(input2);
        ListUtils.removeAll(input2, input3);
        System.out.println(input2);
    }

}