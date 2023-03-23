package lesson_11_list_stack_queue.practice.queue_linkedlist;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (tail == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public Node dequeue() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp;
    }

}
