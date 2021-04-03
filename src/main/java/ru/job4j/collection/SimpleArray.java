package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private  int index = 0;
    private  int capacity = 10;
    private  int modCount = 0;
    private Object[] container = new Object[capacity];

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, this.index)];
    }
    public void add(T model) {
        if (index >= capacity) {
            //container = new Object[capacity * 2];
            container = Arrays.copyOf(container, capacity * 2);
            capacity *= 2;
        }
        container[index] = model;
        index++;
        modCount++;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return position < index;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[position++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        System.out.println(simpleArray.get(0));
        simpleArray.add(2);
        System.out.println(simpleArray.get(1));
        simpleArray.add(3);
        System.out.println(simpleArray.get(2));
        simpleArray.add(4);
        System.out.println(simpleArray.get(3));
        simpleArray.add(5);
        System.out.println(simpleArray.get(4));
        simpleArray.add(6);
        System.out.println(simpleArray.get(5));
        simpleArray.add(7);
        System.out.println(simpleArray.get(6));
        simpleArray.add(8);
        System.out.println(simpleArray.get(7));
        simpleArray.add(9);
        System.out.println(simpleArray.get(8));
        simpleArray.add(10);
        System.out.println(simpleArray.get(9));
        simpleArray.add(11);
        System.out.println(simpleArray.get(10));
        simpleArray.add(12);
        System.out.println(simpleArray.get(11));
        simpleArray.add(13);
        System.out.println(simpleArray.get(12));
        simpleArray.add(14);
        System.out.println(simpleArray.get(13));
        simpleArray.add(15);
        System.out.println(simpleArray.get(14));
    }
}
