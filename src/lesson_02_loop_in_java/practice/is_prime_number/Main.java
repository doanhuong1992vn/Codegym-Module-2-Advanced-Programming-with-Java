package lesson_02_loop_in_java.practice.is_prime_number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        int n = sc.nextInt();
        boolean flag = true;
        if (n < 2) {
            flag = false;
        } else {
            int i = 2;
            while (i <= Math.sqrt(n)) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
                i++;
            }
        }
        if (flag) {
            System.out.printf(n + " is a prime!");
        } else {
            System.out.printf(n + " is NOT a prime!");
        }
    }
}