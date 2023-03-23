package lesson_07_abstract_class_and_interface.resizeable_interface;

import lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape.*;

public class CircleResizeableTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[10];
        //gán phần tử của circles bằng vòng for thường thì được
        for(int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(Math.ceil(Math.random() * 10));
        }
        //nhưng gán phần tử của circles bằng vòng forEach thì trả kết quả phần tử ra null?
//        for(Circle circle: circles) {
//            circle = new Circle(Math.ceil(Math.random() * 10));
//        }
        System.out.println("Before resize: ");
        for(Circle circle: circles) {
            System.out.println(circle);
        }
        System.out.println("After resize: ");
        for(Circle circle: circles) {
            double percent = Math.ceil(Math.random() * 10) * 10;
            circle.resize(percent);
            System.out.println("Radius increase "+ percent + "%");
            System.out.println(circle);
        }
//        System.out.println("After resize: ");
//        for(Circle circle: circles) {
//            System.out.println(circle);
//        }
    }
}
