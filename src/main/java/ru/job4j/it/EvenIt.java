package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int column = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i : numbers) {
            if (numbers[i + 1] % 2 == 0) {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i : numbers) {
            if (i >= column && numbers[i] % 2 == 0) {
                column = numbers[i];
            } else if (i == numbers.length - 1) {
                    column = 0;
                }
                break;
            }
        return column;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        EvenIt evenIt = new EvenIt(test);
        System.out.println(evenIt.next());
        System.out.println(evenIt.next());
        System.out.println(evenIt.next());
    }
}