package lesson_15_exception_handling_and_debug.illegalTriangleException.entity;

import lesson_15_exception_handling_and_debug.illegalTriangleException.exception.IllegalTriangleException;

public class Triangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) throws IllegalTriangleException {
        boolean isAllSidesMoreThanZero = firstSide > 0 && secondSide > 0 && thirdSide > 0;
        boolean isSumTwoSideMoreThanOtherSide =
                firstSide + secondSide > thirdSide
                        && firstSide + thirdSide > secondSide
                        && secondSide + thirdSide > firstSide;
        if(!isAllSidesMoreThanZero){
            throw new IllegalTriangleException("Cạnh của tam giác phải lớn hơn 0!!!");
        } else if (!isSumTwoSideMoreThanOtherSide){
            throw new IllegalTriangleException("Tổng của 2 cạnh phải lớn hơn cạnh còn lại!!!");
        } else {
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
        }
    }

    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }
}
