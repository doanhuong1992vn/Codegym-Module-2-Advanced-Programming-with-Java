package lesson_01_Introduction_to_Java.practice.linear_equation_resolver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a euqation as 'a * x + b = c', please enter constants:");
        Scanner sc = new Scanner(System.in);
        System.out.println("a: ");
        double a = sc.nextDouble();

        System.out.println("b: ");
        double b = sc.nextDouble();

        System.out.println("c: ");
        double c = sc.nextDouble();

        if (a != 0) {
            double result = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", result);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}