package lesson_11_list_stack_queue.optional.demerging_by_queue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) throws ParseException {
        ArrayList<Personnel> sourceList = new ArrayList<>();
        sourceList.add(new Personnel("Hưởng", "Male", "18/02/1992"));
        sourceList.add(new Personnel("Hương", "Female", "14/08/1994"));
        sourceList.add(new Personnel("Nấm", "Female", "27/09/2020"));
        sourceList.add(new Personnel("Thái", "Male", "15/01/1998"));
        sourceList.add(new Personnel("Lâm", "Female", "28/02/1997"));
        sourceList.add(new Personnel("Minh", "Male", "27/08/1996"));
        sourceList.add(new Personnel("Trình", "Female", "18/02/1995"));
        sourceList.add(new Personnel("Khánh", "Male", "18/02/1996"));
        sourceList.add(new Personnel("Phước", "Male", "26/07/1995"));
        sourceList.add(new Personnel("Dưỡng", "Male", "30/04/1997"));
        sourceList.sort(Comparator.comparingLong(Personnel::getMillisOfBirthday));
        System.out.println("Source List Of Personnel: ");
        sourceList.forEach(System.out::println);
        Queue<Personnel> maleList = new LinkedList<>();
        Queue<Personnel> femaleList = new LinkedList<>();

        for (Personnel person : sourceList) {
            if (person.getGender().equals("Male")) {
                maleList.add(person);
            } else {
                femaleList.add(person);
            }
        }
        femaleList.addAll(maleList);
        System.out.println("New List Of Personnel: ");
        femaleList.forEach(System.out::println);
    }
}
