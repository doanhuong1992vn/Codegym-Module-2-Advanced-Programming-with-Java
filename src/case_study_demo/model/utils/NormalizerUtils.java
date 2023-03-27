/*
package case_study_demo.model.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class NormalizerUtils {
    public static String removeAccent(String text) {
        String temp = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }
}
*/
