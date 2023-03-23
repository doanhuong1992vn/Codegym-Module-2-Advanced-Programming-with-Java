package lesson_03_array_method_in_java.exercise.sum_the_numbers_on_the_main_diagonal_of_a_square_matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size less than 10: ");
            size = input.nextInt();
            if (size >= 10 || size <= 0) {
                System.out.println("Invalid input!");
            }
        } while (size >= 10 || size <= 0);
        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter element in row %d: \n", i+1);
            for (int j = 0; j < size; j++) {
                System.out.printf("Enter element in column %d: ", j+1);
                array[i][j] = input.nextDouble();
            }
        }
        double sum = 0d;
        System.out.println("Here is your matrix:");
        for (int i = 0; i < size; i++) {
            sum += array[i][i];
            for (int j = 0; j < size; j++) {
                System.out.printf("%-10.2f", array[i][j]);
            }
            System.out.print("\n");
        }
        System.out.printf("Sum the numbers on the main diagonal of this matrix is: %.2f", sum);
    }
}