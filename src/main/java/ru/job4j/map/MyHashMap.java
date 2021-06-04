package ru.job4j.map;

import java.util.*;

public class MyHashMap<K, V> implements Iterable<K> {
    private int count = 0;
    private  int capacity = 16;
    private  int modCount = 0;
    private Node<K, V>[] container = new Node[capacity];
    private static final double LOAD_FACTOR = 0.75;

    public V get(K key) {
        int index = indexOfBucket(key);
        return (container[index] != null
                && container[index].key.equals(key))
                ? container[index].value : null;
    }
    public boolean insert(K key, V value) {
        if ((double) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int index = indexOfBucket(key);
        if (container[index] != null) {
            return false;
        }
        Node<K, V> node = new Node<>(key, value, null);
        container[index] = node;
            count++;
            modCount++;
           return true;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexOfBucket(key);
        if (!Objects.equals(container[index], null)
                && (container[index].key.equals(key))) {
            container[index] = null;
            result = true;
        }
        return result;
    }
    private int myHash(K key) {
        return (key == null) ? 0 : (key.hashCode()) ^ key.hashCode() >>> 16;
    }
    private int indexOfBucket(K key) {
       return (capacity - 1) & myHash(key);
    }
    private void   expand() {
        capacity *= 2;
        Node<K, V>[] containerLarge = new Node[capacity];
        for (Node<K, V> notNull : container) {
            if (notNull != null) {
                containerLarge[indexOfBucket(notNull.key)] = notNull;
            }
        }
        this.container = containerLarge;
    }
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int position = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
               while (position < container.length && container[position] == null) {
                        position++;
                }
                return position < container.length;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[position++].key;
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
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(0, 1));
        System.out.println(myHashMap.insert(1, 2));
        System.out.println(myHashMap.insert(2, 3));
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println(myHashMap.iterator().next());
        System.out.println(myHashMap.iterator().next());
        System.out.println(myHashMap.iterator().next());



    }
}

