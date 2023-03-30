package case_study_Enjoy_Galaxy.model.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConverter {

    public static String convertDateFormat(String dateFormatInput) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormatInput);
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
