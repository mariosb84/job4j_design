package ru.job4j.map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.it.EvenIt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMapTest {
    
    @Test
    public void whenInsertOneEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        assertThat(myHashMap.get(0), is(1));

    }
    @Test
    public void whenInsertMoreEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.insert(2, 3);
        myHashMap.insert(3, 4);
        myHashMap.insert(4, 5);
        assertThat(myHashMap.get(2), is(3));
    }
    @Test
    public void whenDeleteOneEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.delete(0);
        assertThat(myHashMap.iterator().next(), is(1));

    }
    @Test
    public void whenDeleteMoreEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.insert(2, 3);
        myHashMap.insert(3, 4);
        myHashMap.insert(4, 5);
        myHashMap.delete(0);
        myHashMap.delete(1);
        myHashMap.delete(2);
        myHashMap.delete(3);
        assertThat(myHashMap.iterator().next(), is(4));
    }
    @Test
    public void whenGetOneEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        assertThat(myHashMap.get(0), is(1));

    }
    @Test
    public void whenGetMoreEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.insert(2, 3);
        myHashMap.insert(3, 4);
        myHashMap.insert(4, 5);
        assertThat(myHashMap.get(3), is(4));
    }
    @Test
    public void whenNextEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.insert(2, 3);
        myHashMap.iterator().next();
        myHashMap.iterator().next();
        assertThat(myHashMap.iterator().next(), is(2));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteNextEl() {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.insert(0, 1);
        myHashMap.insert(1, 2);
        myHashMap.insert(2, 3);
        myHashMap.delete(2);
        assertThat(myHashMap.iterator().next(), is(0));
        assertThat(myHashMap.iterator().next(), is(1));
        assertThat(myHashMap.iterator().hasNext(), is(false));
        myHashMap.iterator().next();
    }
}
