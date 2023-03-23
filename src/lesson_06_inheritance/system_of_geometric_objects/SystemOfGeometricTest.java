package lesson_06_inheritance.system_of_geometric_objects;

public class SystemOfGeometricTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", true);
        System.out.println(shape);

        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(50d);
        System.out.println(circle);
        circle = new Circle(10.5d, "yellow", true);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);

        Square square = new Square();
        System.out.println(square);
        square = new Square(2.3);
        System.out.println(square);
        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}
