package lesson_11_list_stack_queue.practice.stack_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<instanceOfElements> {
    private LinkedList<instanceOfElements> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(instanceOfElements element) {
        stack.addFirst(element);
    }

    public instanceOfElements pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.removeFirst();
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
