package ru.job4j.ood;

import org.junit.Test;
import ru.job4j.ood.kiss.MaxMin;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void whenMaxValue() {
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        List<Integer> arrayList = List.of(
                1_500_000_000, 2, 3, 4,
                55674, 6, 7, 80, 9,
                1_500_000_001
        );
        assertThat(maxMin.max(arrayList, comparator), is(1_500_000_001));
    }

    @Test
    public void whenMinValue() {
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        List<Integer> arrayList = List.of(
                1_500_000_000, 2, 3, 4,
                55674, 6, 7, 80, 9,
                1_500_000_001
        );
        assertThat(maxMin.min(arrayList, comparator), is(2));
    }

}
