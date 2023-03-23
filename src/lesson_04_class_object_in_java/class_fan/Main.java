package lesson_04_class_object_in_java.class_fan;

public class Main {
    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        Fan firstFan = new Fan();
        firstFan.setSpeed(FAST);
        firstFan.setRadius(10);
        firstFan.setColor("yellow");
        firstFan.setOn(true);
        System.out.println("Status of first fan: " + firstFan.toString());
        Fan secondFan = new Fan();
        secondFan.setSpeed(MEDIUM);
        secondFan.setRadius(5);
        secondFan.setColor("blue");
        secondFan.setOn(false);
        System.out.println("Status of second fan: " + secondFan.toString());
    }
}