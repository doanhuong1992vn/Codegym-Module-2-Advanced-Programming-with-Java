package lesson_06_inheritance.class_point_and_moveablepoint;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] array = {xSpeed, ySpeed};
        return array;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", speed = (" + xSpeed +
                ", " + ySpeed + ")";
    }
    public MoveablePoint move() {
        setXY(getX()+xSpeed, getY()+ySpeed);
        return this;
    }
}
