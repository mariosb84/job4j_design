package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }
    public T deleteFirst() {
        T valueRem;
        if (head != null) {
            Node<T> rem = head;
            Node<T> remNext = head.next;
            valueRem = rem.value;
            rem.next = null;
            head = remNext;
        } else {
            throw new NoSuchElementException();
        }
        return valueRem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        System.out.println(linked.deleteFirst());
        System.out.println(linked.deleteFirst());
        Iterator<Integer> it = linked.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
