package lesson_10_array_list_and_linked_list.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void testAddAndGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
    }

    @Test
    public void testRemove() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        Assertions.assertTrue(list.remove("banana"));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("apple", list.get(0));
        Assertions.assertEquals("orange", list.get(1));
    }

    @Test
    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testSet() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.set(1, "grape");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("apple", list.get(0));
        Assertions.assertEquals("grape", list.get(1));
        Assertions.assertEquals("orange", list.get(2));
    }

    @Test
    public void testContains() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        Assertions.assertTrue(list.contains("apple"));
        Assertions.assertFalse(list.contains("grape"));
    }
}