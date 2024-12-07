package ru.dianapak.core.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SingleLinkedListImpl<T extends Comparable<T>> implements SingleLinkedList<T>, Serializable {

    private int size;
    private Node<T> head;

    @Override
    public void insert(T val) {
        if (size == 0) {
            head = new Node<>(val);
            size++;
            return;
        }
        insertAfterTail(val);
    }

    @Override
    public void insert(T val, int pos) {
        if (pos == size) {
            insert(val);
            return;
        }
        checkPos(pos);
        var oldNode = getNode(pos);
        oldNode.next = new Node<>(oldNode.value, oldNode.next);
        oldNode.value = val;
        size++;
    }

    @Override
    public void remove(int pos) {
        checkPos(pos);
        if (pos == 0) {
            head = head.next;
            size--;
            return;
        }
        var beforeNode = getNode(pos - 1);
        beforeNode.next = beforeNode.next.next;
        size--;
    }

    @Override
    public T get(int pos) {
        checkPos(pos);
        return getNode(pos).value;
    }

    @Override
    public void forEach(Consumer<T> action) {
        var current = head;
        while (current != null) {
            action.accept(current.value);
            current = current.next;
        }
    }

    /**
     * Merge sort
     */
    @Override
    public void sort() {
        if (size < 2) {
            return;
        }
        List<T> list = toList();
        int mid = size / 2;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>(size);
        forEach(list::add);
        return list;
    }

    private void insertAfterTail(T val) {
        getTail().next = new Node<>(val);
        size++;
    }

    private Node<T> getTail() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private Node<T> getNode(int pos) {
        var current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkPos(int pos) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds (0, " + (size - 1) + ")");
        }
    }

    private static class Node<T> implements Serializable {

        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }
}

