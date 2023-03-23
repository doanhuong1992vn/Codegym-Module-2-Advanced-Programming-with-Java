package lesson_07_abstract_class_and_interface.comparator_interface_for_shape;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Square;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square o1, Square o2) {
        //cố tình để return ngược giữa 1 và -1 để đạt được mục đích riêng
        if (o1.getSide() > o2.getSide()) {
            return -1;
        } else if (o1.getSide() < o2.getSide()) {
            return 1;
        } else return 0;
    }
}
