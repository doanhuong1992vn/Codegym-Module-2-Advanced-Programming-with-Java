package lesson_09_automated_testing_and_TDD.next_day_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToIntegerArrayTest {

    @Test
    void testConvertToIntegerArrayWith01_01_2018() {
        String[] stringArrayOfDate = {"01", "01", "2018"};
        int[] expected = {1, 1, 2018};
        int[] result = NextDayCalculator.convertToIntegerArray(stringArrayOfDate);
        assertArrayEquals(expected, result);
    }
//    @Test
//    void testConvertToIntegerArrayWith31_02_2018() {
//        String[] stringArrayOfDate = {"31", "02", "2018"};
//        int[] expected = {1, 1, 2018};
//        int[] result = NextDayCalculator.convertToIntegerArray(stringArrayOfDate);
//        assertArrayEquals(expected, result);
//    }
}