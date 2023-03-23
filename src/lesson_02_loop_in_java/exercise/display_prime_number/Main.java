package lesson_02_loop_in_java.exercise.display_prime_number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter count of prime would you like to show: ");
        int count = input.nextInt();
        String result = "";
        int n = 2;
        int i = 0;
        while(i < count) {
            if (isPrime(n)) {
                result += Integer.toString(n) + ", ";
                i++;
            }
            n++;
        }
        System.out.printf("The first %d primes are: %s", count, result);
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}