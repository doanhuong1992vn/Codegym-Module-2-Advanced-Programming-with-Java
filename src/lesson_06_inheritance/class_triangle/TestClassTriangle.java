package lesson_06_inheritance.class_triangle;

public class TestClassTriangle {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("blue", true);
        System.out.println(shape);

        Triangle triangle = new Triangle();
        System.out.println(triangle);
        triangle = new Triangle(1,2,3);
        System.out.println(triangle);
        triangle = new Triangle(2,3,2);
        triangle.setColor("yellow");
        triangle.setFilled(true);
        System.out.println(triangle);
        triangle.setSide123(4,5,4);
        System.out.println(triangle);
    }
}
