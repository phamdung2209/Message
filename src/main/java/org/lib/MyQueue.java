package org.lib;

import java.util.Scanner;

public class MyQueue<T> {
    private T[] elements;

    public MyQueue() {
        this.elements = (T[]) new Object[0];
    }

    public void offer(T element) {
        T[] newElements = (T[]) new Object[this.elements.length + 1];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        newElements[this.elements.length] = element;
        this.elements = newElements;
    }

    public T poll() {
        if (this.elements.length == 0) {
            return null;
        }

        T[] newElements = (T[]) new Object[this.elements.length - 1];

        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = this.elements[i + 1];
        }

        T element = this.elements[0];
        this.elements = newElements;

        return element;
    }

    public T peek() {
        if (this.elements.length == 0) {
            return null;
        }

        return this.elements[0];
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
}