package lesson_11_list_stack_queue.optional.stack_use_array;

public class MyStack<E> {
    private final Object[] arr;
    private final int size;
    private int index = 0;

    MyStack(int size) {
        this.size = size;
        arr = new Object[size];
    }

    public boolean isFull() {
        return index == size;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void push(E element) {
        if (isFull()) {
            System.out.println("Overflow ! Unable to add element: " + element);
        } else {
            arr[index] = element;
            index++;
        }
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Stack");
            return null;
        } else {
            index--;
            return (E) arr[index];
        }
    }

    public int size() {
        return index;
    }
}
