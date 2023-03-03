package comparable_interface_for_circle;
import comparable_interface_for_circle.system_of_circle.Circle;

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
        //cố tình để return ngược giữa 1 và -1 để đạt được mục đích riêng
        if (getRadius() < o.getRadius()) {
            return 1;
        } else if (getRadius() > o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
