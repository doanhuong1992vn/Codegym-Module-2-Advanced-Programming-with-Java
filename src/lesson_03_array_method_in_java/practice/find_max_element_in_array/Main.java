package lesson_03_array_method_in_java.practice.find_max_element_in_array;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int max = array[0];
        for (int i: array) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println("Max element is " + max);
    }
}