package lesson_05_access_modifier_static_method_static_property.static_method;

public class Student {
    private int id;
    private String name;
    private static String college = "BBDIT";
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    static void change() {
        college = "Codegym";
    }
    void display() {
        System.out.println(id + " " + name + " " + college);
    }
}
