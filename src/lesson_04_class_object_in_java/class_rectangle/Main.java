package lesson_04_class_object_in_java.class_rectangle;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();
        System.out.println("My rectangle: " + myRectangle.display());
        System.out.println("Perimeter of my rectangle: " + myRectangle.getPerimeter());
        System.out.println("Area of my rectangle: " + myRectangle.getArea());

        Scanner input = new Scanner(System.in);
        System.out.println("Enter width of your rectangle: ");
        double width = input.nextDouble();
        System.out.println("Enter height of your rectangle: ");
        double height = input.nextDouble();

        Rectangle yourRectangle = new Rectangle(width, height);
        System.out.println("Your rectangle: " + yourRectangle.display());
        System.out.println("Perimeter of your rectangle: " + yourRectangle.getPerimeter());
        System.out.println("Area of your rectangle: " + yourRectangle.getArea());
    }
}