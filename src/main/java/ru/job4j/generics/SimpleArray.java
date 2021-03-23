package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<T> {
    private final T[] array;
    private  int index = 0;
    private  int position = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
    array[Objects.checkIndex(index, array.length)] = model;
    index++;
    }
    public boolean set(int index, T model) {
       array[(Objects.checkIndex(index, array.length))] = model;
       return true;
    }
    public boolean remove(int index) {
        boolean result = false;
        if (get(index) != null) {
            System.arraycopy(array, (Objects.checkIndex(index, array.length)) + 1,
                    array, (Objects.checkIndex(index, array.length)), array.length - 1);
            array[array.length - 1] = null;
            result = true;
        }
        return result;
    }
    public  T get(int index) {
       return array[Objects.checkIndex(index, array.length)];
    }

    @Override
    public boolean hasNext() {
        return position < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[position++];
    }
    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(new Object[3]);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
        System.out.println("добавляем 3 элемента :");
        System.out.println(simpleArray.get(0));
        System.out.println(simpleArray.get(1));
        System.out.println(simpleArray.get(2));
        System.out.println("Обходим структуру итератором : ");
        System.out.println(simpleArray.hasNext());
        System.out.println(simpleArray.next());
        System.out.println(simpleArray.hasNext());
        System.out.println(simpleArray.next());
        System.out.println(simpleArray.hasNext());
        System.out.println(simpleArray.next());
        System.out.println("Находим элемент по индексу (0): ");
        System.out.println("0 - я ячейка : " + simpleArray.get(0));
        System.out.println("Находим элемент по индексу (1): ");
        System.out.println("1 - я ячейка : " + simpleArray.get(1));
        System.out.println("Находим элемент по индексу (2): ");
        System.out.println("2 - я ячейка : " + simpleArray.get(2));
        System.out.println("меняем значение 0 - й ячейки : set : 0 - 90");
        System.out.println("set " + simpleArray.set(0, 90));
        System.out.println("значение изменилось на : " + simpleArray.get(0));
        System.out.println("массив стал : ");
        System.out.println(Arrays.toString(simpleArray.array));
        System.out.println("удаляем 0 -ю ячейку : " + simpleArray.remove(0));
        System.out.println("массив стал : ");
        System.out.println(Arrays.toString(simpleArray.array));
        System.out.println("удаляем 0 -ю ячейку : " + simpleArray.remove(0));
        System.out.println("массив стал : ");
        System.out.println(Arrays.toString(simpleArray.array));
        System.out.println("удаляем 0 -ю ячейку : " + simpleArray.remove(0));
        System.out.println("массив стал : ");
        System.out.println(Arrays.toString(simpleArray.array));

    }

}
