package test;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        Student student = new Student();
        Student student2 = (Student) student.clone();
    }
}
