package test;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {
    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }

    public static void main(String[] args) throws ParseException {
        Date dateInput = new SimpleDateFormat("MM/yyyy").parse("4/2023");
        System.out.println(dateInput + "dateinput");
        Calendar calendar = Calendar.getInstance();
        int amount = new Date().getDate() - 1;
//        System.out.println(amount);
        calendar.add(Calendar.DATE, -amount);
        Date firstDateInThisMonth = calendar.getTime();
        String a = new SimpleDateFormat("dd/MM/yyyy").format(firstDateInThisMonth);
//        System.out.println(a + "a");
        Date ne = new SimpleDateFormat("dd/MM/yyyy").parse(a);
//        System.out.println(firstDateInThisMonth + "first");
        System.out.println(ne + "ne");
        System.out.println(dateInput.getTime() == ne.getTime());

        System.out.println(new SimpleDateFormat("MM/yyyy").parse("04/2023"));
        System.out.println(Test.class);
        System.out.println(removeAccent("xin chào đồng chí! ă Â àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễòóọỏõôồốộổỗơờớợởỡìíịỉĩùúụủũưừứựửữỳýỵỷỹ"));
    }
}
