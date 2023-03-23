package lesson_07_abstract_class_and_interface.comparator_interface_for_shape.system_of_shape;
//import resizeable_interface.Resizeable;

import lesson_07_abstract_class_and_interface.colorable_interface.Colorabale;

public class Square extends Rectangle implements Colorabale {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setSide(side, side);
//        setWidth(side);
//        setLength(side);
    }
    public double getArea(){
        return getSide() * getSide();
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide();
//                + ", which is a subclass of "
//                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() + percent * getSide() / 100);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
