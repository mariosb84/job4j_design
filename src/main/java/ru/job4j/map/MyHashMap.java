package ru.job4j.map;

import ru.job4j.collection.ForwardLinked;

import java.util.*;

public class MyHashMap<K, V> implements Iterable<K> {
    private Node<K, V> head;
    private  int index = 0;
    private  int capacity = 16;
    private  int modCount = 0;
    private Object[] container = new Object[capacity];

    public V get(K key) {
        V result = null;
        if ((myHash(key) == myHash(head.key))) {
            result = (V) container[Objects.checkIndex(index, this.index)];
        }
        return result;
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
            result = true;
        }
        Node<K, V> tail = head;
        while (tail.next != null && myHash(key) != myHash(tail.next.key)) {
            tail = tail.next;
        }
        tail.next = node;
                container[index] = value;
                index++;
                modCount++;
                result = true;
           return result;
    }

    public boolean delete(K key) {
        return false;
    }
    private int myHash(K key) {
        return (key.hashCode()) ^ (key.hashCode() >>> capacity);
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

