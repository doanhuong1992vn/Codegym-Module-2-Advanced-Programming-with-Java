package lesson_10_array_list_and_linked_list.mylist_same_arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class RealMyList<instanceOfElement> {
    private int size = 0;
    private final static int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    public RealMyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public RealMyList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid input initialCapacity: " + initialCapacity);
        } else {
            elements = new Object[initialCapacity];
        }
    }

    public void ensureCapacity() {
        int newSize = (int) Math.round(elements.length * 1.5);
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, instanceOfElement element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public instanceOfElement remove(int index) {
        instanceOfElement oldElement = (instanceOfElement) elements[index];
        int numberMoved = size - index - 1;
        System.arraycopy(elements, index + 1, elements, index, numberMoved);
        elements[--size] = null;
        return oldElement;
    }

    public int size() {
        return size;
    }

    public Object[] clone() {
        Object[] newElements = new Object[size];
        System.arraycopy(elements, 0, newElements, 0, size);
        return newElements;
    }

    public boolean contains(instanceOfElement object) {
        return indexOf(object) >= 0;
    }

    public int indexOf(instanceOfElement object) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(instanceOfElement element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }

    public instanceOfElement get(int index) {
        return (instanceOfElement) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
