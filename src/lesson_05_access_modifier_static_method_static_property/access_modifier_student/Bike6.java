package lesson_05_access_modifier_static_method_static_property.access_modifier_student;

public class Bike6 extends Vehicle {
    int speed;

    Bike6(int speed) {
        super();
        this.speed = speed;
        System.out.println(speed);
    }

    public static void main(String args[]) {
        Bike6 b = new Bike6(10);
    }
}