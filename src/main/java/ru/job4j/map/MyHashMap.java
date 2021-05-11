package ru.job4j.map;

import java.util.*;

public class MyHashMap<K, V> implements Iterable<K> {
    private Node<K, V> head;
    private  int index = 0;
    private  int capacity = 16;
    private  int modCount = 0;
    private Object[] container = new Object[capacity];

    public V get(K key) {
       // return (V) container[indexOfBucket(key)];
        return container[indexOfBucket(key)].;
    }
    public boolean insert(K key, V value) {
        boolean result = false;
        if (index >= capacity) {
            container = Arrays.copyOf(container, capacity * 2);
            capacity *= 2;
        }
        Node<K, V> node = new Node<>(key, value, null);
        if (head == null) {
            head = node;
            container[index] = node;
            result = true;
        }
        if (!container[indexOfBucket(key)].equals(node)) {
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
        if (indexOfBucket(key) >= 0) {
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
}

