package lesson_03_array_method_in_java.exercise.number_of_students_passing;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter number of students: ");
            size = input.nextInt();
            if (size > 30 || size < 0) {
                System.out.println("Size should not exceed 30 and less than 0");
            }
        } while (size > 30 || size < 0);
        double[] array = new double[size];
        int i = 0;
        while (i < size) {
            System.out.printf("Enter score of student %d: ", i+1);
            double score = input.nextDouble();
            if (score < 0 || score > 10) {
                System.out.println("Invalid score!");
                continue;
            }
            array[i] = score;
            i++;
        }
        int count = 0;
        System.out.print("Here is list scores of students: ");
        for(double element: array) {
            System.out.printf("%.2f\t", element);
            if (element >= 5) {
                count++;
            }
        }
        System.out.println("\nThe number of students who passed is " + count);
    }
}