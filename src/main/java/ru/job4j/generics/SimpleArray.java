package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SimpleArray {
    private final int[] array;
    private  int index = 0;

    public SimpleArray(int[] array) {
        this.array = array;
    }

    public void add(int model) {
    array[Objects.checkIndex(index, array.length)] = model;
    index++;
    }
    public boolean set(int index, int model) {
        boolean result = false;
       if (get(index) != -1) {
           array[Objects.checkIndex(index, array.length)] = model;
           result = true;
       }
       return result;
    }
    public boolean remove(int index) {
        Objects.checkIndex(index, array.length);
        boolean result = false;
        if (get(index) != -1) {
            System.arraycopy(array, index + 1, array, index, this.index - index);
           // System.arraycopy(array, index + 1, array, index, this.index - index);
            //array[this.index - 1] = null;
            this.index--;
            result = true;
        }
        return result;
    }
    public int get(int index) {
        int result = -1;
           for (int obj : array) {
               obj = array[Objects.checkIndex(index, array.length)];
                   result = obj;
                   break;
           }

        return  result;
    }

    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(new int[3]);
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
    }


}
