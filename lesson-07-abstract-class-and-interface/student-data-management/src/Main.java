import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> initialList = new ArrayList<>();
        initialList.add(new Student("Hưởng", 30));
        initialList.add(new Student("Thái", 23));
        initialList.add(new Student("Minh", 25));
        initialList.add(new Student("Lâm", 24));
        initialList.add(new Student("Trình", 27));
        initialList.add(new Student("Khánh", 26));
        initialList.add(new Student("Phước", 28));
        initialList.add(new Student("Dưỡng", 22));
        Management studentsList = new Management(initialList);
        studentsList.renderStartMenu();
    }
}