package lesson_02_loop_in_java.practice.greatest_common_factor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer a: ");
        int a = input.nextInt();
        System.out.print("Enter integer b: ");
        int b = input.nextInt();
        if (a == 0 && b == 0) {
            System.out.println("No greatest common factor");
        } else if (a >= b) {
            int temp;
            while (b != 0) {
                temp = a % b;
                a = b;
                b = temp;
            }
            System.out.printf("Greatest common factor: " + Math.abs(a));
        } else {
            int temp;
            while (a != 0) {
                temp = b % a;
                b = a;
                a = temp;
            }
            System.out.printf("Greatest common factor: " + Math.abs(b));
        }
    }
}