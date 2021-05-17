package ru.job4j.map;

import java.util.*;

public class MyHashMap<K, V> implements Iterable<K> {
    private  int index = 0;
    private  int capacity = 16;
    private  int modCount = 0;
    private  Node<K, V>[] container;
    private final boolean loadfactor = (float) index / capacity >= 0.75;

    public MyHashMap() {

    }
    public MyHashMap(Node<K, V>[] containerNew) {
        this.container = containerNew;
    }

    public V get(K key) {
        return (container[indexOfBucket(key)].key.equals(key))
                ? (V) container[indexOfBucket(key)] : null;
    }
    public boolean insert(K key, V value) {
        boolean result = false;
        if (loadfactor) {
            new MyHashMap<>(container);
            capacity *= 2;
        }
        Node<K, V> node = new Node<>(key, value, null);
        new MyHashMap<>(container);
        if (Objects.equals(container[indexOfBucket(key)], null)
                || !container[indexOfBucket(key)].equals(node)) {
            index = indexOfBucket(key);
            container[index] = node;
            index++;
            modCount++;
            result = true;
        }
           return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        if ((indexOfBucket(key) >= 0)
                && (container[indexOfBucket(key)].key.equals(key))) {
            container[indexOfBucket(key)] = null;
            result = true;
        }
        return result;
    }
    private int myHash(K key) {
        return (key.hashCode()) ^ (key.hashCode() >>> capacity);
    }
    private int indexOfBucket(K key) {
       return (capacity - 1) & myHash(key);
    }
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int position = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return position < index;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (K) container[position++];
            }
        };
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        System.out.println(myHashMap.insert(1, 155));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.delete(1));
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.insert(1, 155));
        System.out.println(myHashMap.insert(2, 155));
        System.out.println(myHashMap.insert(3, 155));

    }
}

