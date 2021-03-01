package ru.job4j.it;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        //return /*row < data.length && */column < data[row].length;
        //return row >= 0;
        return data.length > 0 && data[row].length > column;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int[] ignored : data) {
                if (data[row].length == 0) {
                  row++;
                }
            if (column >= data[row].length) {
                row++;
                column = 0;
            }
        }
        return data[row][column++];
    }



    public static void main(String[] args) {
        int[][] in = {
                {1, 2, 3}, {2, 3, 4, 5}
        };
        MatrixIt it = new MatrixIt(in);
        System.out.println(it.next());
        System.out.println(it.data.length);
        System.out.println(it.data[1].length);
    }

}
