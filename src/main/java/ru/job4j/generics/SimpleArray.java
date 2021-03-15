package ru.job4j.generics;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator<T> {
    private T model;
    private final T[] array;
    //private Iterator<T> cursor = Collections.emptyIterator();
    private  int index = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
    array[index] = model;
    index++;
    }
    public T set(int index, T model) {
        T result = null;
        for (T obj : array) {
            if (obj != null && index == this.index) {
                result = model;
                break;
            }
            this.index++;
        }
        return  result;
    }
    public T[] remove(int index) {
        return 0;
    }
    public int get(int index) {
        return  0;
    }
    @Override
    public boolean hasNext() {
        while (index < array.length) {
            index++;
        }
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    public static void main(String[] args) {

    }
}
