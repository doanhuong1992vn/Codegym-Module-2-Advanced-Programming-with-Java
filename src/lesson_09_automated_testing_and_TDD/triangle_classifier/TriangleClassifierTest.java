package lesson_09_automated_testing_and_TDD.triangle_classifier;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TriangleClassifierTest {

    @Test
    void testClassifyTriangleWith_2_2_2() {
        double aSide = 2;
        double bSide = 2;
        double cSide = 2;
        String expected = "The equilateral triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
    @Test
    void testClassifyTriangleWith_2_2_3() {
        double aSide = 2;
        double bSide = 2;
        double cSide = 3;
        String expected = "The isosceles triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
    @Test
    void testClassifyTriangleWith_3_4_5() {
        double aSide = 3;
        double bSide = 4;
        double cSide = 5;
        String expected = "The normal triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
    @Test
    void testClassifyTriangleWith_8_2_3() {
        double aSide = 8;
        double bSide = 2;
        double cSide = 3;
        String expected = "Not a triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
    @Test
    void testClassifyTriangleWith_Negative1_2_1() {
        double aSide = -1;
        double bSide = 2;
        double cSide = 1;
        String expected = "Not a triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
    @Test
    void testClassifyTriangleWith_0_1_1() {
        double aSide = 0;
        double bSide = 1;
        double cSide = 1;
        String expected = "Not a triangle";
        String actual = TriangleClassifier.classifyTriangle(aSide, bSide, cSide);
        assertEquals(expected, actual);
    }
}