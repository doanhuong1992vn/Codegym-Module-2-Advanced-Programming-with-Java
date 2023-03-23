package lesson_07_abstract_class_and_interface.comparable_interface_for_circle;
import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(4.5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(1.2, "blue", true);
        System.out.println("Before sort: ");
        for (ComparableCircle circle: circles) {
            System.out.println(circle);
        }
        System.out.println("After sort: ");
        Arrays.sort(circles);
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
