package lesson_11_list_stack_queue.exercise.reverse_by_stack;

import java.util.Stack;

public class ReversedByStack {
    public static void main(String[] args) {
        System.out.println("Reverse integer array by stack: ");
        reverseIntegerArrayByStack();
        System.out.println("Reverse string array by stack: ");
        reverseStringByStack();
    }

    public static void reverseStringByStack() {
        Stack<String> stringStack = new Stack<>();
        String myString = "Hôm nay là thứ sáu";
        System.out.println("Source string before reverse: '" + myString + "'.");
        String[] stringArray = myString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            stringStack.push(stringArray[i]);
            System.out.println(stringStack.get(i));
        }
        myString = "";
        System.out.println(stringStack.size());
        for (int i = 0; i < stringArray.length; i++) {
            myString += stringStack.pop() + " ";
        }
        System.out.println("Source string after reverse: '" + myString + "'.");
    }

    public static void reverseIntegerArrayByStack() {
        Stack<Integer> intStack = new Stack<>();
        int[] srcArray = {1, 2, 3, 4, 5};
        System.out.println("Element of source array before reverse: ");
        for (int element : srcArray) {
            System.out.println(element);
            intStack.push(element);
        }
        System.out.println("Element of source array after reverse: ");
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = intStack.pop();
            System.out.println(srcArray[i]);
        }
    }
}
