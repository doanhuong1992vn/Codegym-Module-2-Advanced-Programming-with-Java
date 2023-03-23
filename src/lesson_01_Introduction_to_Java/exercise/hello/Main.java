package lesson_01_Introduction_to_Java.exercise.hello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.printf("Hello " + name);
    }
}