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
        if (findBy(parent).isEmpty()) {                                            // добавляем parent и child
            new SimpleTree<>(parent);
            // как-то добавить child ???
        } else if (findBy(parent).isPresent() && findBy(child).isEmpty()) {        // добавляем child
            // как-то добавить child ???
            new SimpleTree<>(child);
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
}