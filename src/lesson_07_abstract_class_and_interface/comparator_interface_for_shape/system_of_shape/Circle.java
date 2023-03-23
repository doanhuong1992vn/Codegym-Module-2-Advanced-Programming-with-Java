package lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape;
import lesson_07_abstract_class_and_interface.resizeable_interface.Resizeable;
public class Circle extends Shape implements Resizeable{
    private double radius = 1.0d;
    public Circle(){}
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }
    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + percent * getRadius() / 100);
    }
}
