package lesson_03_array_method_in_java.practice.find_min_element_in_array_by_method;

public class Main {
    public static void main(String[] args) {
        int[] array = {5,7,4,9,3,8,45,2};
        int min = findMinElement(array);
        System.out.printf("The smallest element in the array is: " + min);
    }
    public static int findMinElement(int[] array) {
        int min = array[0];
        for (int element: array) {
            if (min > element) {
                min = element;
            }
        }
        return min;
    }
}