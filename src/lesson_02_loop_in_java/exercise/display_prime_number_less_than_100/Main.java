package lesson_02_loop_in_java.exercise.display_prime_number_less_than_100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        String result = "";
        while (n < 100) {
            if (isPrime(n)) {
                result += String.valueOf(n) + ", ";
            }
            n++;
        }
        System.out.printf("Primes less than 100 are: %s", result);
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