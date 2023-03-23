package lesson_04_class_object_in_java.class_quadraticEquation;

public class QuadraticEquation {
    private double a, b, c;
    public QuadraticEquation (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA () {
        return a;
    }
    public double getB () {
        return b;
    }
    public double getC () {
        return c;
    }
    public String getEquation() {
        return String.valueOf(a) + "x2 + " + String.valueOf(b) + "x + " + String.valueOf(c) + " = 0";
    }
    public double getDiscriminant() {
        return b * 2 - 4 * a * c;
    }
    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        if(getDiscriminant() >= 0) {
            return (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        } else {
            return 0;
        }
    }
}
