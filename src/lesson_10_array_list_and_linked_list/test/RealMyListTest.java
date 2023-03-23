package lesson_10_array_list_and_linked_list.test;

import lesson_10_array_list_and_linked_list.mylist_same_arraylist.RealMyList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RealMyListTest {

    private RealMyList<Integer> elementsList;

    @BeforeEach
    public void setUp() {
        elementsList = new RealMyList<>();
        elementsList.add(1);
        elementsList.add(2);
        elementsList.add(3);
        elementsList.add(4);
        elementsList.add(5);
    }

    @AfterEach
    public void tearDown() {
        elementsList.clear();
    }

    @Test
    public void testAdd() {
        assertEquals(5, elementsList.size());
        elementsList.add(2, 10);
        assertEquals(6, elementsList.size());
        assertEquals(10, elementsList.get(2));
        assertEquals(3, elementsList.get(3));
    }

    @Test
    public void testRemove() {
        assertEquals(5, elementsList.size());
        int removed = elementsList.remove(2);
        assertEquals(3, removed);
        assertEquals(4, elementsList.get(2));
        assertEquals(4, elementsList.size());
    }

    @Test
    public void testSize() {
        assertEquals(5, elementsList.size());
        elementsList.add(6);
        assertEquals(6, elementsList.size());
    }

    @Test
    public void testClone() {
        Object[] arr = elementsList.clone();
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
        assertNotSame(elementsList, arr);
    }

    @Test
    public void testContains() {
        assertTrue(elementsList.contains(3));
        assertFalse(elementsList.contains(6));
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, elementsList.indexOf(3));
        assertEquals(-1, elementsList.indexOf(6));
    }

    @Test
    public void testAddOneElement() {
        assertTrue(elementsList.add(6));
        assertEquals(6, elementsList.size());
        assertEquals(6, elementsList.get(5));
    }

    @Test
    public void testEnsureCapacity() {
        elementsList.ensureCapacity(10);
        assertEquals(10, elementsList.elements.length);
    }
}