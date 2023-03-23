package lesson_07_abstract_class_and_interface.colorable_interface;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Circle;
import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Rectangle;
import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Shape;
import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Square;

public class ColorabaleTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle(2, 3);
        shapes[2] = new Square(2);
        shapes[3] = new Rectangle(3, 3);
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Colorabale) {
                ((Colorabale) shape).howToColor();
            }
        }
    }
}
