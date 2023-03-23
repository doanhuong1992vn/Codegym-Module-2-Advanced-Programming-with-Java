package lesson_04_class_object_in_java.class_fan;

public class Fan {
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = 1;
        this.on = false;
        this.radius = 5d;
        this.color = "blue";
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        if (this.isOn()) {
            return "speed is " + this.getSpeed() + ", color is " + this.getColor() + ", radius is " + this.getRadius() + ", fan is on.";
        } else {
            return "color is " + this.getColor() + ", radius is " + this.getRadius() + ", fan is off.";
        }
    }
}
