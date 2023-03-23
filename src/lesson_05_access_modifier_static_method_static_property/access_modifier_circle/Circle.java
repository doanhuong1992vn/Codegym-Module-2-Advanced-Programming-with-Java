package lesson_05_access_modifier_static_method_static_property.access_modifier_circle;

public class Circle {
    private double radius = 1.0d;
    private String color = "red";
    Circle(){}
    Circle(double radius) {
        this.radius = radius;
    }
    double getRadius() {
        return this.radius;
    }
    String getColor() {
        return this.color;
    }
}
