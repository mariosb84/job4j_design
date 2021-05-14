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
            Node newNode = new Node(child);
            if (root == null) {
                root = newNode;
            } else {
                Node currentNode = root;
                Node parentNode;
                while (true) {
                    parentNode = currentNode;
                    if (child == currentNode.value()) {
                        return false;
                    } else  if (value < currentNode.getValue()) {
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null) {
                            parentNode.setLeftChild(newNode);
                            return false;
                        }
                    } else {
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null) {
                            parentNode.setRightChild(newNode);
                            return false;
                        }
                    }
                }
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
