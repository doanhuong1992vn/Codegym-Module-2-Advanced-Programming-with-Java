package lesson_10_array_list_and_linked_list.mylinkedlist_same_linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(5);
        list.printList();
        list.add(2, 10);
        list.printList();
    }
}
