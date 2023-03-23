package homework.student_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Management {
    private static final Scanner input = new Scanner(System.in);
    private final ArrayList<Student> students;
    private static Student currentStudent;

    public Management(ArrayList<Student> students) {
        this.students = students;
    }

    public void renderStartMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Edit student information");
        System.out.println("3. Delete student");
        System.out.println("4. Show all students");
        System.out.println("5. Find student by ID");
        System.out.println("6. Find student by Name");
        System.out.println("0. Exit");
        int choice = getChoice();
        final int ADD_STUDENT = 1;
        final int EDIT_STUDENT = 2;
        final int DELETE_STUDENT = 3;
        final int SHOW_STUDENTS = 4;
        final int FIND_BY_ID = 5;
        final int FIND_BY_NAME = 6;
        final int EXIT = 0;
        switch (choice) {
            case ADD_STUDENT -> {
                addStudent();
                renderStartMenu();
            }
            case EDIT_STUDENT -> {
                renderSortedStudentsByID();
                long id = getInputID();
                if (checkID(id)) {
                    editStudentById();
                } else {
                    System.out.println("ID " + id + " not found!");
                    renderStartMenu();
                }
            }
            case DELETE_STUDENT -> {
                renderSortedStudentsByID();
                long id = getInputID();
                if (checkID(id)) {
                    removeStudentByID();
                } else {
                    System.out.println("ID not found!");
                    renderStartMenu();
                }
            }
            case SHOW_STUDENTS -> {
                renderSortedStudentsByID();
                choiceToSort();
            }
            case FIND_BY_ID -> {
                long id = getInputID();
                if (checkID(id)) {
                    renderCurrentStudent();
                } else {
                    System.out.println("ID " + id + " not found!");
                    renderStartMenu();
                }
            }
            case FIND_BY_NAME -> {
                System.out.println("Enter name: ");
                String nameSearch = input.nextLine();
                if (checkName(nameSearch)) {
                    renderCurrentStudent();
                } else {
                    System.out.println(nameSearch + " not found!");
                    renderStartMenu();
                }
            }
            case EXIT -> System.exit(0);
            default -> {
                System.out.println("Invalid input!");
                renderStartMenu();
            }
        }
    }

    private void renderSortedStudentsByID() {
        System.out.println("Students List: ");
        students.sort(Comparator.comparingLong(Student::getId));
        students.forEach(System.out::println);
    }

    private static int getChoice() {
        System.out.println("Enter your choice: ");
        return Integer.parseInt(input.nextLine());
    }

    private long getInputID() {
        System.out.println("Enter student's ID: ");
        return Long.parseLong(input.nextLine());
    }

    private boolean checkID(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                currentStudent = student;
                return true;
            }
        }
        return false;
    }

    private boolean checkName(String nameSearch) {
        for (Student student : students) {
            if (nameSearch.equals(student.getName())) {
                currentStudent = student;
                return true;
            }
        }
        return false;
    }

    private void renderCurrentStudent() {
        System.out.println(currentStudent);
        System.out.println("1. Edit " + currentStudent.getName() + "'s information");
        System.out.println("2. Delete " + currentStudent.getName());
        System.out.println("3. Go Back");
        int choice = getChoice();
        final int EDIT = 1;
        final int DELETE = 2;
        final int GO_BACK = 3;
        switch (choice) {
            case EDIT -> editStudentById();
            case DELETE -> removeStudentByID();
            case GO_BACK -> renderStartMenu();
            default -> {
                System.out.println("Invalid input!");
                renderCurrentStudent();
            }
        }
    }

    private void choiceToSort() {
        System.out.println("Sort by: ");
        System.out.println("1. Name");
        System.out.println("2. GPA");
        System.out.println("3. Go Back");
        int choice = getChoice();
        final int NAME = 1;
        final int GPA = 2;
        final int GO_BACK = 3;
        switch (choice) {
            case NAME -> sortByNameAndRender();
            case GPA -> sortByGpaAndRender();
            case GO_BACK -> renderStartMenu();
            default -> System.out.println("Invalid input!");
        }
    }

    private void sortByGpaAndRender() {
        System.out.println("Students List Sorted By GPA: ");
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        students.forEach(System.out::println);
        choiceWhenSort();
    }

    private void sortByNameAndRender() {
        System.out.println("Students List Sorted By Name: ");
        Collections.sort(students);
        students.forEach(System.out::println);
        choiceWhenSort();
    }

    private void choiceWhenSort() {
        System.out.println("1. Go Back");
        System.out.println("0. Exit");
        int choice = getChoice();
        final int GO_BACK = 1;
        final int EXIT = 0;
        switch (choice) {
            case GO_BACK -> choiceToSort();
            case EXIT -> System.exit(0);
            default -> {
                System.out.println("Invalid input!");
                choiceToSort();
            }
        }
    }

    private void removeStudentByID() {
        final String nameStudent = currentStudent.getName();
        System.out.println("Do you confirm to delete " + nameStudent + "? (Yes/No)");
        String choice = input.nextLine();
        switch (choice) {
            case "Y", "y", "YES", "yes", "Yes" -> {
                students.remove(currentStudent);
                System.out.println(nameStudent + " has been removed from the students list.");
            }
            case "N", "n", "NO", "no", "No" -> {
                System.out.println("OK, " + nameStudent + " has been kept on Students List");
                renderStartMenu();
            }
            default -> {
                System.out.println("Invalid input!");
                removeStudentByID();
            }
        }
    }

    public void addStudent() {
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter address: ");
        String address = input.nextLine();
        System.out.println("Enter GPA: ");
        double gpa = Double.parseDouble(input.nextLine());
        Student newStudent = new Student(name, age, address, gpa);
        students.add(newStudent);
        System.out.println("Student " + name + " has add to students list");
        renderStartMenu();
    }

    public void editStudentById() {
        System.out.println("Edit student " + currentStudent);
        System.out.println("1. Edit name");
        System.out.println("2. Edit age");
        System.out.println("3. Edit address");
        System.out.println("4. Edit GPA");
        System.out.println("5. Go Back");
        System.out.println("0. Exit Program");
        int choice = getChoice();
        final int EDIT_NAME = 1;
        final int EDIT_AGE = 2;
        final int EDIT_ADDRESS = 3;
        final int EDIT_GPA = 4;
        final int GO_BACK = 5;
        final int EXIT = 0;
        switch (choice) {
            case EDIT_NAME -> {
                editName();
                editStudentById();
            }
            case EDIT_AGE -> {
                editAge();
                editStudentById();
            }
            case EDIT_ADDRESS -> {
                editAddress();
                editStudentById();
            }
            case EDIT_GPA -> {
                editGPA();
                editStudentById();
            }
            case GO_BACK -> renderStartMenu();
            case EXIT -> System.exit(0);
            default -> {
                System.out.println("Invalid choice!");
                editStudentById();
            }
        }

    }

    private void editName() {
        System.out.println("Enter new name: ");
        String newName = input.nextLine();
        currentStudent.setName(newName);
        System.out.println("Student at ID" + currentStudent.getId() + " has change name to " + newName);
    }

    private void editAge() {
        int newAge;
        do {
            System.out.println("Enter new age: ");
            newAge = Integer.parseInt(input.nextLine());
            if (newAge <= 18 || newAge > 80) {
                System.out.println("Invalid input!");
            }
        } while (newAge <= 18 || newAge > 80);
        currentStudent.setAge(newAge);
        System.out.println("Student at ID " + currentStudent.getId() + " has change age to " + newAge);
    }

    private void editAddress() {
        System.out.println("Enter new address: ");
        String newAddress = input.nextLine();
        currentStudent.setAddress(newAddress);
        System.out.println("Student at ID " + currentStudent.getId() + " has change address to " + newAddress);
    }

    private void editGPA() {
        double newGPA;
        do {
            System.out.println("Enter new GPA: ");
            newGPA = Double.parseDouble(input.nextLine());
            if (newGPA < 0 || newGPA > 10) {
                System.out.println("Invalid input!");
            }
        } while (newGPA < 0 || newGPA > 10);
        currentStudent.setGpa(newGPA);
        System.out.println("Student at ID " + currentStudent.getId() + " has change GPA to " + newGPA);
    }
}
