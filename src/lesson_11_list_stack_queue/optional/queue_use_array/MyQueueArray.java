package lesson_11_list_stack_queue.optional.queue_use_array;

public class MyQueueArray<E> {
    private final int capacity;
    private final Object[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;
    public MyQueueArray(int capacity){
        this.capacity = capacity;
        queueArr = new Object[capacity];
    }
    public boolean isQueueFull(){
        return currentSize == capacity;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public void enqueue(E item){
        if(!isQueueFull()){
            tail++;
            if (tail == capacity) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        } else {
            System.out.println("Overflow ! Unable to add element: " + item);
        }
    }
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++;
            if (head == capacity) {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
