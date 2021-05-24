package ru.job4j.map;

import java.util.*;

public class MyHashMap<K, V> implements Iterable<K> {
    private  int index = 0;
    private  int capacity = 16;
    private  int modCount = 0;
    private Node<K, V>[] container = new Node[capacity];
    private static final double LOAD_FACTOR = 0.75;

    /*public MyHashMap() {
        Node<K, V>[] containerNew = new Node[capacity];
        this.container = containerNew;
    }*/

    public V get(K key) {
        return (container[indexOfBucket(key)] != null
                && container[indexOfBucket(key)].key.equals(key))
                ? (V) container[indexOfBucket(key)] : null;
    }
    public boolean insert(K key, V value) {
        boolean result = false;
        if ((double) index / capacity >= LOAD_FACTOR) {
            expand();
        }
        Node<K, V> node = new Node<>(key, value, null);
        if (Objects.equals(container[indexOfBucket(key)], null)
                || container[indexOfBucket(key)].equals(node)) {
            index = indexOfBucket(key);
            container[index] = node;
            modCount++;
            result = true;
        }
           return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (!Objects.equals(container[indexOfBucket(key)], null)
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
    private Node<K, V>[] expand() {
        capacity *= 2;
        int i = 0;
        Node<K, V>[] containerLarge = new Node[capacity];
        for (Node<K, V> notNull : container) {
            if (notNull != null) {
                containerLarge[indexOfBucket(notNull.key)] = container[i];
            }
            i++;
        }
        this.container = containerLarge;
        return container;
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
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(1, 1));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Get: ");
        System.out.println(myHashMap.get(1));
        System.out.println("Delete: ");
        System.out.println(myHashMap.delete(1));
        System.out.println("Get: ");
        System.out.println(myHashMap.get(1));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(2, 2));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(3, 3));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(4, 4));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(5, 5));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(6, 6));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(7, 7));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(8, 8));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(9, 9));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(10, 10));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(11, 11));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(12, 12));
        System.out.println("Add: ");
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Container: ");
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println(myHashMap.insert(13, 13));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(14, 14));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(15, 15));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(16, 16));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Container: ");
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println("Index: ");
        System.out.println(myHashMap.index);
        System.out.println("Container[0]: ");
        System.out.println(myHashMap.container[0].value);
        System.out.println("Container[10]: ");
        //System.out.println(myHashMap.container[10].value);
        System.out.println("Container.length: ");
        System.out.println(myHashMap.container.length);
        System.out.println("Capacity: ");
        System.out.println(myHashMap.capacity);

    }
}

