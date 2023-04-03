package case_study_Enjoy_Galaxy.model.utils;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Converter {
    public static StringBuilder convertNameToCode(String name) {
        String[] arrayOfWordsInMovieTheaterName = name.split(" ");
        StringBuilder code = new StringBuilder();
        for (String word : arrayOfWordsInMovieTheaterName) {
            code.append(word.charAt(0));
        }
        return removeAccent(code);
    }
    public static StringBuilder removeAccent(StringBuilder text) {
        return new StringBuilder(removeAccent(text.toString()));
    }

    public static String removeAccent(String text) {
        text = text.toUpperCase().trim();
        String temp = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("Đ", "D");
    }

    public static String convertDateFormat(String dateFormatInput) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormatInput);
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static Date convertToBeginningOfDate(Date date) throws ParseException {
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat);
    }

    public static String formatPrice(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        return numberFormat.format(price);
    }

    public static String getDateFormat24H(Date date) {
        return new SimpleDateFormat("dd MMMM yyyy HH:mm a").format(date);
    }

    public static String getHourFormat24HByDate(Date date) {
        return new SimpleDateFormat("HH:mm a").format(date);
    }

    public static Date convertToBeginningOfNextDay(Date date) throws ParseException {
        date = convertToBeginningOfDate(date);
        final long TIME_OF_ONE_DAY = 1000L * 60 * 60 * 24;
        long timeOfNextDay = date.getTime() + TIME_OF_ONE_DAY;
        return new Date(timeOfNextDay);
    }
    public static Date getEndTimeByShowtimeWithMovie(Date showtime, Movie movie) {
        long timeOfShowtime = showtime.getTime();
        long timeOfMovieDuration = movie.getMovieDuration() * 60 * 1000L;
        long timeOfEndTime = timeOfShowtime + timeOfMovieDuration;
        return new Date(timeOfEndTime);
    }

    public static Date convertToRealEndTimeAfterCleaningTime(Date endTime) {
        final long TIME_DELAY = 30 * 60 * 1000;
        long timeEnd = endTime.getTime();
        long time = timeEnd + TIME_DELAY;
        return new Date(time);
    }
}