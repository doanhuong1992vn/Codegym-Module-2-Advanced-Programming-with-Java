package lesson_03_array_method_in_java.exercise.find_min_in_array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            System.out.printf("Enter element %d: ", i);
            array[i] = input.nextInt();
        }
        int min = array[0];
        System.out.print("Your array: ");
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
            if(min > array[i]) {
                min = array[i];
            }
        }
        System.out.printf("\nThe smallest element in array is %d", min);
    }
}