package lesson_03_array_method_in_java.exercise.sum_the_numbers_in_a_specified_column;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size less than 10: ");
            size = input.nextInt();
            if (size > 10 || size < 0) {
                System.out.println("Invalid input!");
            }
        } while (size > 10 || size < 0);
        double[][] array = new double[size][size];
        System.out.println("Here is your matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = j * 2.5;
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.print("\n");
        }
        int column;
        do {
            System.out.print("Enter the column you want to sum: ");
            column = input.nextInt();
            if (column > size || column < 0) {
                System.out.println("Invalid input!");
            }
        } while (column > size || column < 0);
        double sum = 0.0d;
        for (int i = 0; i < size; i++) {
            sum += array[i][column-1];
        }
        System.out.printf("Sum of element in column %d is: %f", column, sum);
    }
}