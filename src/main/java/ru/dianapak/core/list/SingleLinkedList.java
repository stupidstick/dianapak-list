package ru.dianapak.core.list;

import java.util.List;
import java.util.function.Consumer;

public interface SingleLinkedList<T extends Comparable<T>> {

    void insert(T val);

    void insert(T val, int pos);

    void remove(int pos);

    T get(int pos);

    void forEach(Consumer<T> action);

    void quickSort();

    int size();

    List<T> toList();
}
