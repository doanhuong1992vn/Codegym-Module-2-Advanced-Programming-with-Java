import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Scanner input = new Scanner(System.in);
        System.out.print("Element in source array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.print("\nEnter element to delete: ");
        int number = input.nextInt();
        int index = 0;
        while (index < array.length) {
            if (number == array[index]) {
                System.out.println(number + " is element " + index + " in source array.");
                for (int i = index; i < array.length-1; i++) {
                    array[i] = array[i + 1];
                }
                System.out.print("Element in new array: ");
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[j] + "\t");
                }
                break;
            }
            index++;
        }
        if (index == array.length) {
            System.out.println(number + " is NOT an element in array!");
        }
    }
}