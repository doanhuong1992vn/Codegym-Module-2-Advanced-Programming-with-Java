package lesson_04_class_object_in_java.class_rectangle;

public class Rectangle {
    double width = 1d;
    double height = 1d;
    public Rectangle() {
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return (width + height) * 2;
    }
    public String display() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }
}
