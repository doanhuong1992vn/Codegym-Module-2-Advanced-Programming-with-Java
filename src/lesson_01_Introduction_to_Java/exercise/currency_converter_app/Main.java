package lesson_01_Introduction_to_Java.exercise.currency_converter_app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USD Value: ");
        double usdValue = sc.nextDouble();
        double vndValue = usdValue * rate;
        System.out.printf("%-15s%-15s\n", "USD", "VND");
        System.out.printf("%-15.4f%-15.4f", usdValue, vndValue);
    }
}