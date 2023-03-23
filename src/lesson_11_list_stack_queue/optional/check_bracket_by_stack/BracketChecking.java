package lesson_11_list_stack_queue.optional.check_bracket_by_stack;

import java.util.Stack;

public class BracketChecking {
    public static void main(String[] args) {
        String bracket = "((2 + 3) - 4) * (()(())";
        Stack<Character> myStack = new Stack<>();
        boolean isValid;
        for (int i = 0; i < bracket.length(); i++) {
            char currentCharacter = bracket.charAt(i);
            if (currentCharacter == '(') {
                myStack.push(currentCharacter);
            } else if (currentCharacter == ')') {
                if (myStack.isEmpty()) {
                    myStack.push(currentCharacter);
                    break;
                } else if (myStack.peek() == '(') {
                    myStack.pop();
                }
            }
        }
        if (myStack.isEmpty()) {
            System.out.println("The bracket is valid!");
        } else {
            System.out.println("The bracket is NOT valid!");
        }
    }
}
