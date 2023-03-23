package lesson_11_list_stack_queue.optional.decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class Convert {
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner input = new Scanner(System.in);
        int decimal = input.nextInt();
        System.out.println(decimal + " in Binary is: " + getBinary(decimal));
    }

    public static String getBinary(int decimal) {
        Stack<Integer> myStack = new Stack<>();
        int remainder;
        int quotient = -1;
        while (quotient != 0) {
            quotient = decimal / 2;
            remainder = decimal % 2;
            decimal = quotient;
            myStack.push(remainder);
        }
        String result = "";
        while (!myStack.isEmpty()) {
            result += String.valueOf(myStack.pop());
        }
        return result;
    }
}
