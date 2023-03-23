package lesson_03_array_method_in_java.exercise.find_max_in_two_dimensional_arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        int row = input.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int column = input.nextInt();
        int[][] array = new int[row][column];
        for(int i = 0; i < row; i++) {
            System.out.printf("Enter elements in row %d: \n", i+1);
            for(int j = 0; j < column; j++) {
                System.out.printf("Enter element at column %d in row %d: ", j+1, i+1);
                array[i][j] = input.nextInt();
            }
        }
        int max = array[0][0];
        int indexRow = 0;
        int indexColumn = 0;
        System.out.println("Here is your matrix:");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(array[i][j] + "\t");
                if (max < array[i][j]) {
                    max = array[i][j];
                    indexRow = i + 1;
                    indexColumn = j + 1;
                }
            }
            System.out.print("\n");
        }
        System.out.printf("The largest element in matrix is %d at column %d in row %d", max, indexColumn, indexRow);
    }
}