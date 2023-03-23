package lesson_06_inheritance.class_triangle;

public class Triangle extends Shape{
    private double side1 = 1.0d;
    private double side2 = 1.0d;
    private double side3 = 1.0d;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            System.out.println("Invalid input");
        }
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        if(side2 + side3 > side1) {
            this.side1 = side1;
        } else {
            System.out.println("Invalid input");
        }
    }

    public void setSide2(double side2) {
        if(side1 + side3 > side2) {
            this.side2 = side2;
        } else {
            System.out.println("Invalid input");
        }
    }

    public void setSide3(double side3) {
        if(side1 + side2 > side3) {
            this.side3 = side3;
        } else {
            System.out.println("Invalid input");
        }
    }
    public double[] getSide123(){
        double[] array = {side1, side2, side3};
        return array;
    }
    public void setSide123(double side1, double side2, double side3){
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            setSide1(side1);
            setSide2(side2);
            setSide3(side3);
        } else {
            System.out.println("Invalid input");
        }
    }
    public double getArea(){
        double halfOfPerimeter = getPerimeter() / 2;
        double area = Math.sqrt(halfOfPerimeter * (halfOfPerimeter-side1) * (halfOfPerimeter-side2) * (halfOfPerimeter-side3));
        return area;
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1 = " + side1 + "m" +
                ", side2 = " + side2 + "m" +
                ", side3 = " + side3 + "m" +
                "} with " + super.toString() +
                ", area = " + String.format("%.2f", getArea()) + "m2" +
                ", perimeter = " + getPerimeter() + "m";
    }
}
