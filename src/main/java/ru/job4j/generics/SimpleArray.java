package ru.job4j.generics;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator {
    private final T[] array;
    private final List array2 = new List();
    private  int index = 0;
    private  int position = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
    array[Objects.checkIndex(index, array.length)] =  model;
    index++;
    }
    public boolean set(int index, T model) {
        boolean result = false;
       if (get(index) != null) {
           array[Objects.checkIndex(index, array.length)] = model;
           result = true;
       }
       return result;
    }
    public boolean remove(int index) {
        boolean result = false;
        if (get(index) != null) {
            System.arraycopy(array, (Objects.checkIndex(index, array.length)) + 1,
                    array, (Objects.checkIndex(index, array.length)), array.length - 1);
            array[array.length - 1] = null;
            //this.index--;
            result = true;
        }
        return result;
    }
    public  T get(int index) {
        T result = null;
       // List<T>arrayAsList = new Arrays.asList<T>(array);
       // Iterator iterator = ((java.util.List) arrayAsList).iterator();
        Iterator<T> iterator = array.iterator();                                                 // не работает?????
        while (iterator.hasNext()) {
            T obj = iterator.next();
            if (obj.equals(array[Objects.checkIndex(index, array.length)])) {
            result = obj;
            break;
            }
        }
              /* for (T obj : array) {
               obj = array[Objects.checkIndex(index, array.length)];
                   result = obj;
                   break;
           }*/

        return  result;
    }

    @Override
    public boolean hasNext() {
        return position < array.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return position++;
    }
    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(new Object[3]);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
        System.out.println(simpleArray.index);
        System.out.println();
        System.out.println(simpleArray.get(0));
        System.out.println(simpleArray.get(1));
        System.out.println(simpleArray.get(2));
        System.out.println();
        System.out.println(simpleArray.set(0, 90));
        System.out.println(simpleArray.get(0));
        System.out.println();
        System.out.println(Arrays.toString(simpleArray.array));
        System.out.println(simpleArray.index);
        System.out.println(simpleArray.remove(0));
        System.out.println(Arrays.toString(simpleArray.array));

    }

}
