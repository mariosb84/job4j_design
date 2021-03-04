package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int iterator = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
            while (iterator < numbers.length  && !(numbers[iterator] % 2 == 0)) {
                iterator++;
            }
        return  iterator < numbers.length;
    }


    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[iterator++];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        EvenIt evenIt = new EvenIt(test);
        System.out.println(evenIt.hasNext());
        System.out.println(evenIt.next());
        System.out.println(evenIt.hasNext());
        System.out.println(evenIt.next());
        System.out.println(evenIt.hasNext());
        System.out.println(evenIt.next());
        System.out.println();
        System.out.println(evenIt.iterator);
        System.out.println(evenIt.hasNext());
        System.out.println(evenIt.next());
    }
}