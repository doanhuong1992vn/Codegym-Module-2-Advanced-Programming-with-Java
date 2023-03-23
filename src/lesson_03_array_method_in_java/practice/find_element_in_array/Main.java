package lesson_03_array_method_in_java.practice.find_element_in_array;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] students = {"Phước", "Dưỡng", "Thái", "Lâm", "Hưởng", "Minh", "Khánh", "Trình"};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên muốn tìm: ");
        String name = input.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(name)) {
                System.out.println("Position of the students in the list " + name + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found" + name + " in the list.");
        }
    }
}