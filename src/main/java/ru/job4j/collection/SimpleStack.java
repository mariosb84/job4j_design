package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
      linked.addFirst(value);
    }
    public boolean isEmpty() {
        return !linked.iterator().hasNext();
    }

    public static void main(String[] args) {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.isEmpty());
        System.out.println(simpleStack.linked);
    }
}
