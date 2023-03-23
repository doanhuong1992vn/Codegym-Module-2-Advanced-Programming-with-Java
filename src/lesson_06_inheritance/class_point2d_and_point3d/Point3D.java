package lesson_06_inheritance.class_point2d_and_point3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ() {
        float[] array = {getX(), getY(), z};
        return array;
    }
    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        setZ(z);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", z = " + z;
    }
}
