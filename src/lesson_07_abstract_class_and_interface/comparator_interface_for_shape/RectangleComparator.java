package lesson_07_abstract_class_and_interface.comparator_interface_for_shape;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Rectangle;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        //cố tình để return ngược giữa 1 và -1 để đạt được mục đích riêng
        if(o1.getArea() > o2.getArea()) {
            return -11;
        } else if (o1.getArea() < o2.getArea()) {
            return 1;
        } else return 0;
    }
}
