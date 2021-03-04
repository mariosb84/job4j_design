package ru.job4j.it;

import java.util.Arrays;
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
       /* int k = 0;
        for (int[] i : data) {
            if (i.length != 0) {
                k++;
            }
            if (column >= data[row].length) {
                row++;
                column = 0;
            }
        }
        return k > 0;*/
        while (row < data.length && column >= data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            return data[row][column++];
    }



    public static void main(String[] args) {
        int[][] in = {
                {}, {2, 3, 4, 5}
        };
        MatrixIt it = new MatrixIt(in);
        System.out.println(it.hasNext());
        System.out.println(it.row);
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.row);
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.row);
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.row);
        System.out.println(it.next());
        //System.out.println(it.next());
        /*System.out.println(it.data.length);
        System.out.println(it.data[1].length);
        System.out.println(Arrays.toString(it.data[0]));
        System.out.println((it.data[1][0]));
        System.out.println(Arrays.toString(it.data[1]));*/
    }

}
