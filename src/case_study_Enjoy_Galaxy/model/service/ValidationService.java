package case_study_Enjoy_Galaxy.model.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String FULL_NAME_REGEX = "^[a-zA-Z\\sàáạã_-]{3,25}$";
    private static final String PHONE_NUMBER_REGEX = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
    private static final String PASSWORD_REGEX = "^((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})$";
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]" +
            "\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])" +
            "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean validate(String regex, String regexPattern) {
        switch (regexPattern) {
            case "FULL_NAME" -> pattern = Pattern.compile(FULL_NAME_REGEX);
            case "EMAIL" -> pattern = Pattern.compile(EMAIL_REGEX);
            case "PHONE_NUMBER" -> pattern = Pattern.compile(PHONE_NUMBER_REGEX);
            case "DATE" -> pattern = Pattern.compile(DATE_REGEX);
            case "PASSWORD" -> pattern = Pattern.compile(PASSWORD_REGEX);
        }
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
