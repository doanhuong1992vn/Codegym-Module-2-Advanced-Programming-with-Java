package lesson_03_array_method_in_java.practice.convert_temperature;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%15s\n", "Menu");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("0. Exit ");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter Fahrenheit: ");
                double fahrenheit = input.nextDouble();
                System.out.printf(fahrenheit + "*F = " + fahrenheitToCelsius(fahrenheit) + "*C");
            }
            case 2 -> {
                System.out.print("Enter Celsius: ");
                double celsius = input.nextDouble();
                System.out.printf(celsius + "*C = " + celsiusToFahrenheit(celsius) + "*F");
            }
            case 0 -> System.exit(0);
            default -> System.out.print("No choice!");
        }

    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9 / 5 + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}