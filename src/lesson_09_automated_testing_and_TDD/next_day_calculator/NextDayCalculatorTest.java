package lesson_09_automated_testing_and_TDD.next_day_calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NextDayCalculatorTest {

    @Test
    void testGetNextDayOf1_1_2018() {
        String date = "1/1/2018";
        String expected = "2/1/2018";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOf31_1_2018() {
        String date = "31/1/2018";
        String expected = "1/2/2018";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOf30_4_2018() {
        String date = "30/4/2018";
        String expected = "1/5/2018";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOf28_2_2018() {
        String date = "28/2/2018";
        String expected = "1/3/2018";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOf29_2_2020() {
        String date = "29/2/2020";
        String expected = "1/3/2020";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOf31_12_2018() {
        String date = "31/12/2018";
        String expected = "1/1/2019";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError1() {
        String date = "31/12/2018/18";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError2() {
        String date = "31/13/2018";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError3() {
        String date = "30/2/2018";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError4() {
        String date = "31/4/2018";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError5() {
        String date = "29/2/2011";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }
    @Test
    void testGetNextDayOfError6() {
        String date = "32/1/2011";
        String expected = "Invalid input!";
        String result = NextDayCalculator.getNextDay(date);
        assertEquals(expected, result);
    }

}