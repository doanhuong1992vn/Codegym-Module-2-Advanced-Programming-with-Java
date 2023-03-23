package lesson_09_automated_testing_and_TDD.next_day_calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTest {
    public static void main(String[] args) throws ParseException {
        String input = "29/02/2020";
        //chuyển chuỗi input thành đối tượng Date:
        Date today = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        //chuyển định dạng toString() của today thành dd/MM/yyyy:
        String stringFormatToday = new SimpleDateFormat("dd/MM/yyyy").format(today);
        System.out.println(stringFormatToday);
        final long NUMBER_MILLIS_OF_1_DAY = 24 * 60 * 60 * 1000;
        final long NUMBER_MILLIS_OF_TODAY = today.getTime();
        final long NUMBER_MILLIS_OF_TOMORROW = NUMBER_MILLIS_OF_TODAY + NUMBER_MILLIS_OF_1_DAY;
        //tạo đối tượng tomorrow bằng cách truyền tham số là số millis tính tới ngày mai
        Date tomorrow = new Date(NUMBER_MILLIS_OF_TOMORROW);
        String stringFormatTomorrow = new SimpleDateFormat("dd/MM/yyyy").format(tomorrow);
        System.out.println(stringFormatTomorrow);
    }
}
