package homework.student_management;

public class Student implements Comparable<Student> {
    private static long numberStudents = 0;
    private final static long ID_BEGIN = 100;
    private final long id;
    private String name;
    private int age;
    private String address = "";
    private double gpa;

    public Student(String name, int age, double gpa) {
        ++numberStudents;
        this.id = numberStudents + ID_BEGIN;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public Student(String name, int age, String address, double gpa) {
        ++numberStudents;
        this.name = name;
        this.id = numberStudents + ID_BEGIN;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String addressString = address.equals("") ? "not update." : address;
        return name + ": ID = " + id + ", age = " + age + ", GPA = " + gpa + ", address is " + addressString;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return name.compareTo(otherStudent.getName());
    }
}
