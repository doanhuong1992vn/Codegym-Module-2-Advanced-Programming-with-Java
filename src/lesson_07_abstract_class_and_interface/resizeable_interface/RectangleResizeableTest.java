package lesson_07_abstract_class_and_interface.resizeable_interface;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.Rectangle;

public class RectangleResizeableTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[10];
        for (int i = 0; i < rectangles.length; i++) {
            double randomWidth = Math.ceil(Math.random()*10);
            double randomLength = Math.ceil(Math.random()*10);
            rectangles[i] = new Rectangle(randomWidth, randomLength);
        }
        System.out.println("Before resize: ");
        for(Rectangle rectangle: rectangles) {
            System.out.println(rectangle);
        }
        System.out.println("After resize both side: ");
        for (Rectangle rectangle: rectangles) {
            double percent = Math.ceil(Math.random() * 10) * 10;
            rectangle.resize(percent);
            System.out.println("Side increase " + percent + "%");
            System.out.println(rectangle);
        }
    }
}
