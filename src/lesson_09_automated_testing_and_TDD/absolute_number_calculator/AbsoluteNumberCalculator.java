package lesson_09_automated_testing_and_TDD.absolute_number_calculator;

public class AbsoluteNumberCalculator {
    public static int findAbsolute(int number) {
        if (number < 0) {
            return -number;
        } else return number;
    }
}
