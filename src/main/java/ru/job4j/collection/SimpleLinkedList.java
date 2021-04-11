package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private  int modCount = 0;
    private  int size = 0;
    private  Node<E> fstNode;
    private  Node<E> lstNode;

    public SimpleLinkedList() {
        lstNode = new Node<>(null, null, null);
        fstNode = new Node<>(null, null, lstNode);
    }

    private static class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E element, Node<E> prev, Node<E> next) {
            this.currentElement = element;
            this.nextElement = next;
            this.prevElement = prev;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }
        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
    @Override
    public void add(E value) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(value);
        lstNode = new Node<>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < Objects.checkIndex(index, this.size); i++) {
         target = getNextElement(target);
        }
        return target.getCurrentElement();
    }
    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int position = 0;
            private final int expectedModCount = modCount;
            Node<E> current = fstNode;

            @Override
            public boolean hasNext() {
                //return current != lstNode;
                return  position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                current = current.getNextElement();
                position++;
                return current.getCurrentElement();
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
        System.out.println();
        Iterator<Integer> first = simpleLinkedList.iterator();
        System.out.println(first.next());
        System.out.println(first.next());
        System.out.println(first.next());
    }
}
