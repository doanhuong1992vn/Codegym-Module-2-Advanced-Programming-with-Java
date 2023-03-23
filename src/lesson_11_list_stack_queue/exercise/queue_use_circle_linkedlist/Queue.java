package lesson_11_list_stack_queue.exercise.queue_use_circle_linkedlist;

public class Queue {
    Node front;
    Node rear;

    public void enQueue(int data) {
        Node currentNode = new Node(data);
        if (front == null) {
            front = currentNode;
        } else {
            rear.link = currentNode;
            currentNode.link = front;
        }
        rear = currentNode;
        rear.link = front;
    }

    public void deQueue() {
        if (front == null) {
            return;
        } else {
            if (front.equals(rear)) {
                front = null;
                rear = null;
            } else {
                front = front.link;
                rear.link = front;
            }
        }
    }

    public void displayQueue() {
        Node currentNode = front;
        int index = 0;
        while (!front.equals(currentNode.link)) {
            System.out.println("Data in node " + index + " is " + currentNode.data);
            currentNode = currentNode.link;
            index++;
        }
        System.out.println("Data in node " + index + " is " + currentNode.data);
    }
}
