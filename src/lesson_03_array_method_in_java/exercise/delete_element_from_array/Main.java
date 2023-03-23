package lesson_03_array_method_in_java.exercise.delete_element_from_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Scanner input = new Scanner(System.in);
        System.out.println("Element in source array: " + Arrays.toString(array));
        System.out.print("Enter element to delete: ");
        int number = input.nextInt();
        int index = 0;
        while (index < array.length) {
            if (number == array[index]) {
                System.out.println(number + " is element " + index + " in source array.");
                for (int i = index; i < array.length-1; i++) {
                    array[i] = array[i + 1];
                }
                System.out.print("Element in new array: " + Arrays.toString(array));
                break;
            }
            index++;
        }
        if (index == array.length) {
            System.out.println(number + " is NOT an element in array!");
        }
    }
}