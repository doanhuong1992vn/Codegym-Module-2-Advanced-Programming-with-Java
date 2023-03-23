package lesson_06_inheritance.class_circle_and_cylinder;

public class Circle {
    private double radius = 1.0d;
    private String color = "red";
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this(radius);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
