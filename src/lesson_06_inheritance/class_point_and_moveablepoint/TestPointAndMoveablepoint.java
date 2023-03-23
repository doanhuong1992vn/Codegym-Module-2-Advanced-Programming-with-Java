package lesson_06_inheritance.class_point_and_moveablepoint;

public class TestPointAndMoveablepoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(5, 6);
        System.out.println(point);

        MoveablePoint newPoint = new MoveablePoint();
        System.out.println(newPoint);
        newPoint = new MoveablePoint(3, 4, 2, 2);
        System.out.println(newPoint);
        System.out.println(newPoint.move());

    }

}
