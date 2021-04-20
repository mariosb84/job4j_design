package ru.job4j.collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Iterator;

public class RevLinkedTest {

    @Test
    public void whenAddThenIterator() {
        RevLinked<Integer> linked = new RevLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIterator() {
        RevLinked<Integer> linked = new RevLinked<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        RevLinked<Integer> emptyList = new RevLinked<>();
        assertFalse(emptyList.revert());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        RevLinked<Integer> singleList = new RevLinked<>();
        singleList.add(1);
        assertFalse(singleList.revert());
    }

}
