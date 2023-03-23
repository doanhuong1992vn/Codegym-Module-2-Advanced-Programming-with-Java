package lesson_03_array_method_in_java.exercise.count_char_in_string;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world! Hello Codegym! I'm new student.";
        Scanner input = new Scanner(System.in);
        System.out.println("Here is Hello String: 'Hello world! Hello Codegym! I'm new student.'");
        System.out.print("Enter char you want to count: ");
        String inputText = input.nextLine();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            String character = String.valueOf(text.charAt(i));
            if(inputText.equals(character)) {
                count++;
            }
        }
        System.out.printf("Char %s exist %d times in Hello String.", inputText, count);
//    m(1, 2, 3);
//        int[] a = {1, 2, 3, 4};
//        System.out.println(m(a));
    }
//    static int m(int...x) {
//        int b = 0;
//        for(int a:x){
//            b+=a;
//        }
//        return b;
//    }
}