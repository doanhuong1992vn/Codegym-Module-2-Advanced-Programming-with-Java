package lesson_05_access_modifier_static_method_static_property.access_modifier_student;

public class TestStudent {
    public static void main(String[] args) {
        Student doanHuong = new Student();
        doanHuong.setName("Doan Van Huong");
        doanHuong.setClasses("C1222H1");
        System.out.println(doanHuong.getName() + " in " + doanHuong.getClasses());
    }
}