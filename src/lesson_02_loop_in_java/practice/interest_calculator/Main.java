package lesson_02_loop_in_java.practice.interest_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        double money = sc.nextDouble();
        System.out.print("Enter number of months: ");
        int month = sc.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        double interestRate = sc.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate/100)/12;
        }
        System.out.printf("Total of interest: " + totalInterest);
    }
}