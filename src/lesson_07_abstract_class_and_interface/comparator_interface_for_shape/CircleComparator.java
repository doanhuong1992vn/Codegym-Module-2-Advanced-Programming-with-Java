package lesson_07_abstract_class_and_interface.comparator_interface_for_shape;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if(o1.getRadius() > o2.getRadius()) {
            return -1;
        } else if (o1.getRadius() < o2.getRadius()) {
            return 1;
        } else {
            return 0;
        }
    }
}
