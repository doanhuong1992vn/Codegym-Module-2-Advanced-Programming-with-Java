package lesson_10_array_list_and_linked_list.simple_list;

import java.util.Arrays;

public class MyList<typeElements> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(typeElements newElement){
        if(size == elements.length) {
            ensureCapa();
        }
        elements[size++] = newElement;
    }
    public typeElements get(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + index);
        } else {
            return (typeElements) elements[index];
        }
    }

}
