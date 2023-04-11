package test;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws ParseException {
<<<<<<< HEAD
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println(intList.size());
        System.out.println(intList.get(3));


        Date date1 = new Date();
        System.out.println(date1);
        Date date2 = new Date(date1.getTime() + 1);
        System.out.println(date2);
        System.out.println(date2.after(date1));
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
=======
>>>>>>> 84d3ff04a064086d1ec132070c1222cb4c104e56
    }
}
