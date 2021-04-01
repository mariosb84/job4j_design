package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private  int index = 0;
    private  int i = 3;
    private  int modCount = 0;

    private final Object[] container = new Object[i];

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, this.index)];                    // ???????????????
    }

    public void add(T model) {
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
        SimpleArray simpleArray = new SimpleArray();
        simpleArray.add(1);
        System.out.println(simpleArray.get(0));
        simpleArray.add(2);
        System.out.println(simpleArray.get(1));
        simpleArray.add(3);
        System.out.println(simpleArray.get(2));
        simpleArray.add(4);
        System.out.println(simpleArray.get(3));
    }
}
