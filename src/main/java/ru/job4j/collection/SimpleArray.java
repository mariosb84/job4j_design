package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private  int index = 0;
    private  int i = 3;
    private  int modCount = 0;
    private Object[] container = new Object[i];

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, this.index)];                    // ???????????????
    }
    public void add(T model) {
        if (index >= i) {
            container = new Object[i * 2];
            i *= 2;
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
                return (T) container[position++];                                     // ???????????????
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
    }
}
