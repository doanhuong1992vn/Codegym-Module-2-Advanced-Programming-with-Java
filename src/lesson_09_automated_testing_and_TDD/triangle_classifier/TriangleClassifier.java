package lesson_09_automated_testing_and_TDD.triangle_classifier;

public class TriangleClassifier {
    public static String classifyTriangle(double aSide, double bSide, double cSide) {
        if (isTriangle(aSide, bSide, cSide)) {
            if (isIsoscelesTriangle(aSide, bSide, cSide)) {
                if (isEquilateralTriangle(aSide, bSide, cSide)) {
                    return "The equilateral triangle";
                } else {
                    return "The isosceles triangle";
                }
            } else {
                return  "The normal triangle";
            }
        } else {
            return "Not a triangle";
        }
    }

    private static boolean isEquilateralTriangle(double aSide, double bSide, double cSide) {
        return aSide == bSide && aSide == cSide;
    }

    private static boolean isIsoscelesTriangle(double aSide, double bSide, double cSide) {
        return aSide == bSide || aSide == cSide || bSide == cSide;
    }

    private static boolean isTriangle(double aSide, double bSide, double cSide) {
        if (aSide > 0 && bSide > 0 && cSide > 0) {
            return aSide + bSide > cSide && aSide + cSide > bSide && bSide + cSide > aSide;
        } else return false;
    }
}
