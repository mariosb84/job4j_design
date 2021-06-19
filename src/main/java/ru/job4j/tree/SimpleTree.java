package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
    @Override
    public boolean isBinary() {
        Optional<Node<E>> binaryNode;
        binaryNode =  findByPredicate(node -> ((node.children.size() > 2)));
        return binaryNode.isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode =  findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (childNode.isPresent()) {
          return false;
        }
        if (parentNode.isPresent()) {
             parentNode.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(node -> node.value.equals(value));
    }

    public static void main(String[] args) {
        SimpleTree<Integer> simpleTree = new SimpleTree<>(5);
        System.out.println(simpleTree.add(5, 6));
        System.out.println(simpleTree.add(5, 7));
        System.out.println(simpleTree.add(5, 8));
        System.out.println(simpleTree.add(5, 9));
        System.out.println(simpleTree.findBy(2));
        System.out.println(simpleTree.findBy(3));
        System.out.println(simpleTree.findBy(4));
        System.out.println(simpleTree.findBy(5));
        System.out.println(simpleTree.findBy(6));
        System.out.println(simpleTree.isBinary());
        System.out.println(simpleTree.root.children.size());
    }
}
