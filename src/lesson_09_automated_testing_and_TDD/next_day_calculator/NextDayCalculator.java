package lesson_09_automated_testing_and_TDD.next_day_calculator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NextDayCalculator {
    public static @NotNull String getNextDay(@NotNull String date) {
        String[] stringArrayOfDate = date.split("/");
        int[] intArrayOfDate = convertToIntegerArray(stringArrayOfDate);
        if (isValidDate(intArrayOfDate)) {
            int day = intArrayOfDate[0];
            int month = intArrayOfDate[1];
            int year = intArrayOfDate[2];
            if (isLastDayOfMonth(day, month, year)) {
                if (isLastDayOfYear(day, month)) {
                    return "1/1/" + (year + 1);
                } else {
                    return "1/" + (month + 1) + "/" + year;
                }
            } else {
                return (day + 1) + "/" + month + "/" + year;
            }
        } else {
            return "Invalid input!";
        }
    }

    private static boolean isLastDayOfYear(int day, int month) {
        return day == 31 && month == 12;
    }

    private static boolean isLastDayOfMonth(int day, int month, int year) {
        if (isMonthHas31Days(month)) {
            return day == 31;
        } else if (isMonthHas30Days(month)) {
            return day == 30;
        } else {
            if (isLeafYear(year)) {
                return day == 29;
            } else {
                return day == 28;
            }
        }
    }

    private static boolean isLeafYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean isMonthHas30Days(int month) {
        return switch (month) {
            case 4, 6, 9, 11 -> true;
            default -> false;
        };
    }

    private static boolean isMonthHas31Days(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> true;
            default -> false;
        };
    }

    public static int @NotNull [] convertToIntegerArray(String @NotNull [] stringArrayOfDate) {
        int[] intArrayOfDate = new int[stringArrayOfDate.length];
        for (int i = 0; i < stringArrayOfDate.length; i++) {
            intArrayOfDate[i] = Integer.parseInt(stringArrayOfDate[i]);
        }
        return intArrayOfDate;
    }

    public static @NotNull ArrayList<Integer> getDayArray() {
        ArrayList<Integer> dayArray = new ArrayList<>(31);
        for (int i = 1; i <= 31; i++) {
            dayArray.add(i);
        }
        return dayArray;
    }

    public static @NotNull ArrayList<Integer> getMonthArray() {
        ArrayList<Integer> monthArray = new ArrayList<>(12);
        for (int i = 1; i <= 12; i++) {
            monthArray.add(i);
        }
        return monthArray;
    }

    public static boolean isValidDate(int @NotNull [] intArrayOfDate) {
        if (intArrayOfDate.length != 3) {
            return false;
        } else {
            int day = intArrayOfDate[0];
            int month = intArrayOfDate[1];
            int year = intArrayOfDate[2];
            final boolean IS_DAY_BETWEEN_1_AND_31 = getDayArray().contains(day);
            final boolean IS_MONTH_BETWEEN_1_AND_12 = getMonthArray().contains(month);
            if (IS_DAY_BETWEEN_1_AND_31 && IS_MONTH_BETWEEN_1_AND_12) {
                if (isMonthHas31Days(month) && day <= 31) {
                    return true;
                } else if (isMonthHas30Days(month) && day <= 30) {
                    return true;
                } else if (isLeafYear(year) && day <= 29) {
                    return true;
                } else return day <= 28;
            } else return false;
        }
    }
}
