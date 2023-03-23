package lesson_11_list_stack_queue.exercise.queue_use_circle_linkedlist;

public class QueueByCircleLinkedList {
    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(7);
        myQueue.displayQueue();
    }
}
