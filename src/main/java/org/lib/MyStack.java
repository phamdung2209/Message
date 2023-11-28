package org.lib;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

// TODO: Stack
public class MyStack<T> {
    private T[] elements;

    public MyStack() {
        this.elements = (T[]) new Object[0];
    }

    public void push(T element) {
        T[] newElements = (T[]) new Object[this.elements.length + 1];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        newElements[this.elements.length] = element;
        this.elements = newElements;
    }

    public T pop() {
        if (this.elements.length == 0) {
            return null;
        }

        T[] newElements = (T[]) new Object[this.elements.length - 1];

        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = this.elements[i];
        }

        T element = this.elements[this.elements.length - 1];
        this.elements = newElements;

        return element;
    }

    public T peek() {
        if (this.elements.length == 0) {
            return null;
        }

        return this.elements[this.elements.length - 1];
    }

    public boolean isEmpty() {
        return this.elements.length == 0;
    }

    public int size() {
        return this.elements.length;
    }

    public void clear() {
        this.elements = (T[]) new Object[0];
    }

    public T[] getElements() {
        return elements;
    }
}