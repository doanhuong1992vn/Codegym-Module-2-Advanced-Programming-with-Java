package homework.student_management;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> initialList = new ArrayList<>();
        initialList.add(new Student("Hưởng", 30, 9.0));
        initialList.add(new Student("Thái", 23, 7.5));
        initialList.add(new Student("Minh", 25, 8.5));
        initialList.add(new Student("Lâm", 24, 7.0));
        initialList.add(new Student("Trình", 27, 8.0));
        initialList.add(new Student("Khánh", 26, 7.5));
        initialList.add(new Student("Phước", 28, 7.0));
        initialList.add(new Student("Dưỡng", 22, 8.5));
        Management studentsList = new Management(initialList);
        studentsList.renderStartMenu();
    }
}