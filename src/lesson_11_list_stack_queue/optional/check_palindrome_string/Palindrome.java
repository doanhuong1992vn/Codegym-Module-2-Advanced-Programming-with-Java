package lesson_11_list_stack_queue.optional.check_palindrome_string;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringInput = "abcdecba";
        String[] arrayInput = stringInput.split("");
        Stack<String> myStack = getStack(arrayInput);
        Queue<String> myQueue = getQueue(arrayInput);
        if (isPalindrome(myStack, myQueue)) {
            System.out.println("That is a palindrome");
        } else {
            System.out.println("That is NOT a palindrome");
        }

    }

    public static <E> Stack<E> getStack(E[] array) {
        Stack<E> myStack = new Stack<>();
        for (E element : array) {
            myStack.push(element);
        }
        return myStack;
    }

    public static <E> Queue<E> getQueue(E[] array) {
        return new LinkedList<>(Arrays.asList(array));
    }

    public static <E> boolean isPalindrome(Stack<E> myStack, Queue<E> myQueue) {
        while (!myStack.isEmpty() || !myQueue.isEmpty()) {
            E lastElementOfStack = myStack.pop();
            E firtElementOfQueue = myQueue.remove();
            if (!lastElementOfStack.equals(firtElementOfQueue)) {
                return false;
            }
        }
        return true;
    }
}
