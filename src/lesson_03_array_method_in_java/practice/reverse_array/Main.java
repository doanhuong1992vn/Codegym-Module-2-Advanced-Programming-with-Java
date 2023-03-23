package lesson_03_array_method_in_java.practice.reverse_array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter size of array: ");
            size = input.nextInt();
            if (size > 5) {
                System.out.println("Size does not exceed 5");
            }
        } while (size > 5);
        array = new int[size];
        for (int i = 1; i <= array.length; i++) {
            System.out.printf("Enter element %d in array: ", i);
            array[i-1] = input.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + "\t");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}