package ru.job4j.tree;

import java.util.*;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> parentNode =  root;
        Node<E> childNode = new Node<>(child);
        if (findBy(child).isPresent()) {
          return false;
        }
        if (findBy(parent).isPresent()) {
             parentNode.children.add(childNode);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public static void main(String[] args) {
        SimpleTree<Integer> simpleTree = new SimpleTree<>(1);
        System.out.println(simpleTree.add(1, 2));
        System.out.println(simpleTree.add(2, 3));
        System.out.println(simpleTree.add(3, 4));
        System.out.println(simpleTree.add(3, 4));
        System.out.println(simpleTree.add(4, 5));
        System.out.println(simpleTree.add(5, 6));
        System.out.println(simpleTree.findBy(2));
        System.out.println(simpleTree.findBy(3));
        System.out.println(simpleTree.findBy(4));
        System.out.println(simpleTree.findBy(5));
        System.out.println(simpleTree.findBy(6));
    }
}
