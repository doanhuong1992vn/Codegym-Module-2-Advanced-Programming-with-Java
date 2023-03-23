package lesson_06_inheritance.class_point2d_and_point3d;

import java.util.Arrays;

public class TestClassPoint2DAndPoint3D {
    public static void main(String[] args) {
        Point2D point2d = new Point2D();
        System.out.println(point2d);
        System.out.println(Arrays.toString(point2d.getXY()));
        System.out.println(point2d.getX());
        System.out.println(point2d.getY());
        point2d.setXY(3, 4);
        System.out.println(point2d);
        point2d = new Point2D(5, 6);
        System.out.println(point2d);
        System.out.println(Arrays.toString(point2d.getXY()));
        System.out.println(point2d.getX());
        System.out.println(point2d.getY());

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(6, 7, 8);
        System.out.println(point3D);


    }
}
