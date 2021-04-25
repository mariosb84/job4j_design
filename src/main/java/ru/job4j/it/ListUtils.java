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
            if (filter.test(i.next())) {
                i.remove();
                break;
            }
            i.next();
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {

    }

    public static <T> void removeAll(List<T> list, List<T> elements) {

    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 9, 10));
        ListUtils.addBefore(input, 1, 1);
        ListUtils.addAfter(input, 2, 3);
        ListUtils.addBefore(input, 5, 5);
        ListUtils.addAfter(input, 6, 7);
        System.out.println(input);
        Predicate<Integer> moreTwo = x -> x > 2;
        ListUtils.removeIf(input, moreTwo);
        System.out.println(input);
    }

}