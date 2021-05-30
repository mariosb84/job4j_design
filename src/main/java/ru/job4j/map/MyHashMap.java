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
        System.out.println(myHashMap.insert(1, 1));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Get: ");
        System.out.println(myHashMap.get(1));
        System.out.println("Delete: ");
        System.out.println(myHashMap.delete(1));
        System.out.println("Get: ");
        System.out.println(myHashMap.get(1));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(2, 2));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
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
        System.out.println(myHashMap.count);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(10, 10));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(11, 11));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(12, 12));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Container: ");
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println(myHashMap.insert(13, 13));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(14, 14));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(15, 15));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(16, 16));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Container: ");
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);
        System.out.println("Container[0]: ");
        //System.out.println(myHashMap.container[0].value);
        //System.out.println("Container[10]: ");
        //System.out.println(myHashMap.container[10].value);
        System.out.println("Container.length: ");
        System.out.println(myHashMap.container.length);
        System.out.println("Capacity: ");
        System.out.println(myHashMap.capacity);
        System.out.println("container values :");
        //System.out.println(myHashMap.container[0].value);
        //System.out.println(myHashMap.container[1].value);
        System.out.println(myHashMap.container[2].value);
        System.out.println(myHashMap.container[3].value);
        System.out.println(myHashMap.container[4].value);
        System.out.println(myHashMap.container[5].value);
        System.out.println(myHashMap.container[6].value);
        System.out.println(myHashMap.container[7].value);
        System.out.println(myHashMap.container[8].value);
        System.out.println(myHashMap.container[9].value);
        System.out.println(myHashMap.container[10].value);
        //System.out.println(myHashMap.container[11].value);
        //System.out.println(myHashMap.container[12].value);
        //System.out.println(myHashMap.container[13].value);
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(17, 17));
        System.out.println("Add: ");
        System.out.println(myHashMap.insert(25, 25));
        System.out.println("Container: ");
        System.out.println(Arrays.toString(myHashMap.container));
        System.out.println("Index: ");
        System.out.println(myHashMap.count);


    }
}

