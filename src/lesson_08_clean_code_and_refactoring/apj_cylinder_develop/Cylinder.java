package lesson_08_clean_code_and_refactoring.apj_cylinder_develop;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        return perimeter * height + 2 * baseArea;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
