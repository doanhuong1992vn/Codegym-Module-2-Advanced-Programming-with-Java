package lesson_12_collection_framework.practice_hashmap_difference_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashmapAndHashset {
    public static void main(String[] args) {
        Student firstStudent = new Student("Huong", 31);
        Student secondStudent = new Student("Minh", 26);
        Student thirdStudent = new Student("Thai", 24);
        Student fourthStudent = new Student("Lam", 25);
        HashMap<Integer, Student> hashMap = new HashMap<>();
        hashMap.put(1, firstStudent);
        hashMap.put(4, secondStudent);
        hashMap.put(3, thirdStudent);
        hashMap.put(2, fourthStudent);
        System.out.println("Hash Map:");
        System.out.println(hashMap);

        Set<Student> set = new HashSet<>();
        set.add(firstStudent);
        set.add(secondStudent);
        set.add(thirdStudent);
        set.add(fourthStudent);
        System.out.println("Hash Set:");
        System.out.println(set);
    }
}
