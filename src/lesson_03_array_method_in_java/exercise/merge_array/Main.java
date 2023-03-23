package lesson_03_array_method_in_java.exercise.merge_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //nhập dữ liệu mảng thứ nhất:
        System.out.print("Enter size of the first array: ");
        int firstSize = input.nextInt();
        int[] firstArray = new int[firstSize];
        for (int i = 0; i < firstSize; i++) {
            System.out.printf("Enter element %d: ", i);
            firstArray[i] = input.nextInt();
        }
        System.out.println("Element in the first array: " + Arrays.toString(firstArray));
        //nhập dữ liệu mảng thứ 2:
        System.out.print("Enter size of the second array: ");
        int secondSize = input.nextInt();
        int[] secondArray = new int[secondSize];
        for (int i = 0; i < secondSize; i++) {
            System.out.printf("Enter element %d: ", i);
            secondArray[i] = input.nextInt();
        }
        System.out.print("Element in the second array: " + Arrays.toString(secondArray));
        //tạo mảng thứ 3:
        int thirdSize = firstSize + secondSize;
        int[] thirdArray = new int[thirdSize];
        //gán các phần tử mảng 1 vào mảng 3:
        System.out.print("\nElement in the third array: ");
        for (int i = 0; i < firstSize; i++) {
            thirdArray[i] = firstArray[i];
            System.out.print(thirdArray[i] + "\t");
        }
        //khai báo biến index = chiều dài mảng 1 để làm chỉ mục bắt đầu khi gán phần tử mảng 2 vào mảng 3
        int index = firstSize;
        for (int i = 0; i < secondSize; i++, index++) {
            thirdArray[index] = secondArray[i];
            System.out.print(thirdArray[index] + "\t");
        }

    }
}