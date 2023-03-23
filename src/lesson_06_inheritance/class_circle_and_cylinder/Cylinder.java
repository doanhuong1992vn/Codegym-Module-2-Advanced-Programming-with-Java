package lesson_06_inheritance.class_circle_and_cylinder;

public class Cylinder extends Circle {
    private double height = 1.0d;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return height * getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height + "m" +
                " and " + super.toString() +
                "} has volume = " + String.format("%.2f", getVolume()) + "m3.";
    }
}
