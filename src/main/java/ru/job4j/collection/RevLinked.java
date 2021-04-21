package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RevLinked<T> implements Iterable<T> {
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

    public boolean revert() {
        //TODO impl reverts of linked list.
        boolean result = false;
        Node<T> current = head;
        Node<T> beforeCurrent = null, afterCurrent;
            if (current != null && current.next != null) {
                while (current != null) {
                    afterCurrent = current.next;
                    current.next = beforeCurrent;
                    beforeCurrent = current;
                    current = afterCurrent;
                    head = beforeCurrent;
                    result = true;
                }
        }
        return result;
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
        RevLinked<Integer> revLinked = new RevLinked<>();
        revLinked.add(1);
        revLinked.add(2);
        revLinked.add(3);
        System.out.println(revLinked.revert());
        Iterator<Integer> it = revLinked.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

    }
}
