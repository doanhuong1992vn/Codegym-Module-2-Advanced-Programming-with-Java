package lesson_03_array_method_in_java.exercise.add_element_to_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.print("Element in source array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
            System.out.print(array[i] + "\t");
        }
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter element to insert: ");
        int element = input.nextInt();
        System.out.print("Enter index to insert element: ");
        int index = input.nextInt();
        if (index < 0 || index >= array.length) {
            System.out.print("Unable to insert element into array!");
        } else {
            for (int i = array.length -1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
            System.out.print("Element in new array: " + Arrays.toString(array));
        }
    }
}