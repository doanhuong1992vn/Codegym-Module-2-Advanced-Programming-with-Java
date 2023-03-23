package lesson_06_inheritance.class_circle_and_cylinder;

public class TestClassCircleAndCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5.0d);
        System.out.println(circle);
        circle = new Circle(10.5d, "green");
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(15);
        System.out.println(cylinder);
        cylinder = new Cylinder(16, 20);
        System.out.println(cylinder);
        cylinder = new Cylinder(10, "blue", 12);
        System.out.println(cylinder);
    }
}
