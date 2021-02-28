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
        // return row < data.length || column < data.length;
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int[] num : data) {
            for (int i : num) {
               /*if (i > num.length) {
                  row++;
               }*/
                column = i;
            }
            //column++;
            if (num != null) {
                row++;
            }
            //row++;
        }
        //return data[row][column];
        return data[0][0];
    }

}
