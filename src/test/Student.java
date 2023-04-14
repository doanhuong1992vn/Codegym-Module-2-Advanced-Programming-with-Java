package test;

public class Student implements Cloneable{
    private long id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
