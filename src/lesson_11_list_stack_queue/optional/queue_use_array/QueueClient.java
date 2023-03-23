package lesson_11_list_stack_queue.optional.queue_use_array;

public class QueueClient {
    public static void main(String[] args) {
        MyQueueArray<Integer> queue = new MyQueueArray<>(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}
