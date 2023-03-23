package lesson_15_exception_handling_and_debug.illegalTriangleException.view;

import lesson_15_exception_handling_and_debug.illegalTriangleException.entity.Triangle;
import lesson_15_exception_handling_and_debug.illegalTriangleException.exception.IllegalTriangleException;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        while (true) {
            try {
                double firstSide = Double.parseDouble(prompt("Enter the first side:"));
                double secondSide = Double.parseDouble(prompt("Enter the second side: "));
                double thirdSide = Double.parseDouble(prompt("Enter the third side: "));
                Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
                System.out.println("Chu vi: " + triangle.getPerimeter());
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
//                e.getCause();
                e.printStackTrace();

            } catch (IllegalTriangleException e) {
                System.err.println(e.getMessage());
                e.getCause();
                e.printStackTrace();
            }
            System.out.println("Dòng này vẫn được chạy ra nếu có lỗi.");
        }
    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }
}
