package lesson_07_abstract_class_and_interface.comparable_interface_for_circle;

import lesson_07_abstract_class_and_interface.comparable_interface_for_circle.system_of_circle.Circle;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() < o.getRadius()) {
            return 1;
        } else if (getRadius() > o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
