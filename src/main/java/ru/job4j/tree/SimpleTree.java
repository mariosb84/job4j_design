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
        //Node<E> parentNode = new Node<>(parent);
        Node<E> childNode = new Node<>(child);
        if (findBy(child).isPresent()) {
          return false;
        }
        /*if (findBy(parent).isEmpty()) {
            parentNode.children.add(childNode);
            rsl = true;
        } else*/ if (findBy(parent).isPresent()) {
            root.children.add(childNode);
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
        System.out.println(simpleTree.add(1, 3));
        System.out.println(simpleTree.add(1, 4));
        System.out.println(simpleTree.add(1, 3));
        System.out.println(simpleTree.add(1, 4));
        System.out.println(simpleTree.findBy(1));
        System.out.println(simpleTree.findBy(2));
        System.out.println(simpleTree.findBy(3));
        System.out.println(simpleTree.findBy(4));
    }
}
