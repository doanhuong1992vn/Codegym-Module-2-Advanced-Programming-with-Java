package lesson_12_collection_framework.practice_use_hashmap_linkedhashmap_treemap;

import java.util.*;


public class PracticeMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("DoanHuong", 31);
        hashMap.put("LeHuong", 29);
        hashMap.put("TueNhi", 2);
        hashMap.put("HongQuan", 58);
        hashMap.put("ThuThuy", 52);
        System.out.println("Display entries in hash map:");
        System.out.println(hashMap);

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(3, 0.01f, false);
        linkedHashMap.put("DoanHuong", 31);
        linkedHashMap.put("LeHuong", 29);
        linkedHashMap.put("TueNhi", 2);
        linkedHashMap.put("HongQuan", 58);
        linkedHashMap.put("ThuThuy", 52);
        System.out.println("By Linked hash map:");
        System.out.println(linkedHashMap);

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
    }
}
