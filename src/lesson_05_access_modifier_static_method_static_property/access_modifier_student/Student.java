package lesson_05_access_modifier_static_method_static_property.access_modifier_student;

public class Student {
    private String name = "Doan Huong";
    private String classes = "C12";
    Student(){}
    String getName() {
        return this.name;
    }
    String getClasses() {
        return this.classes;
    }

     protected void setName(String name) {
        this.name = name;
    }

     protected void setClasses(String classes) {
        this.classes = classes;
    }
}
