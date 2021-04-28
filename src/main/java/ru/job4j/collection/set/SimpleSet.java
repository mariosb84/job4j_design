package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        boolean result = false;
       if (!contains(value)) {
           set.add(value);
           result = true;
       }
        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T t : set) {
            if (t.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    public static void main(String[] args) {
        Set<Integer> set2 = new SimpleSet<>();
        System.out.println(set2.add(1));
        System.out.println(set2.add(2));
        System.out.println(set2.add(3));
        System.out.println();
        System.out.println(set2.contains(4));
        System.out.println(set2.contains(3));
        System.out.println();
        Iterator<Integer> it = set2.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        //System.out.println(it.next());
    }
}
