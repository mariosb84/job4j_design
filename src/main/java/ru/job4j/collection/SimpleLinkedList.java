package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private  int capacity = 10;
    private  int modCount = 0;
    private transient int size = 0;
    private transient Node first;
    private transient Node last;
    private Node[] node = new Node[capacity];
    @Override
    public void add(E value) {
        if (size >= capacity) {
            node = Arrays.copyOf(node, capacity * 2);
            capacity *= 2;
        }
        //node[size] = (Node) value;
       // node[size] = value;
       // first = (Node) value;
       //last = (Node) value;
       // new Node(value);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        return (E) node[Objects.checkIndex(index, this.size)];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int position = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) node[position++];
            }
        };
    }
    public static void main(String[] args) {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        System.out.println(simpleLinkedList.get(0));
        simpleLinkedList.add(2);
        System.out.println(simpleLinkedList.get(1));
        simpleLinkedList.add(3);
        System.out.println(simpleLinkedList.get(2));
        simpleLinkedList.add(4);
        System.out.println(simpleLinkedList.get(3));
        simpleLinkedList.add(5);
        System.out.println(simpleLinkedList.get(4));
        simpleLinkedList.add(6);
        System.out.println(simpleLinkedList.get(5));
        simpleLinkedList.add(7);
        System.out.println(simpleLinkedList.get(6));
        simpleLinkedList.add(8);
        System.out.println(simpleLinkedList.get(7));
        simpleLinkedList.add(9);
        System.out.println(simpleLinkedList.get(8));
        simpleLinkedList.add(10);
        System.out.println(simpleLinkedList.get(9));
        simpleLinkedList.add(11);
        System.out.println(simpleLinkedList.get(10));
        simpleLinkedList.add(12);
        System.out.println(simpleLinkedList.get(11));
        simpleLinkedList.add(13);
        System.out.println(simpleLinkedList.get(12));
        simpleLinkedList.add(14);
        System.out.println(simpleLinkedList.get(13));
        simpleLinkedList.add(15);
        System.out.println(simpleLinkedList.get(14));
    }
}
