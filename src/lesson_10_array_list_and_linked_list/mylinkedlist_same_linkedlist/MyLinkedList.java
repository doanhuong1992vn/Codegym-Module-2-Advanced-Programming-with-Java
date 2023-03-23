package lesson_10_array_list_and_linked_list.mylinkedlist_same_linkedlist;

public class MyLinkedList<E> {
    private Node headNode;
    //    private Node tail;
    private int numNodes;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] elementsData) {
        headNode = new Node(elementsData);
        numNodes++;
    }

    private class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element) {
            this.element = element;
        }
    }

    public void add(int index, E element) {
        if (index >= 0 && index <= numNodes) {
            Node previousNode = headNode;
            for (int i = 1; i < index && previousNode.nextNode != null; i++) {
                previousNode = previousNode.nextNode;
            }
            Node nextNode = previousNode.nextNode;
            previousNode.nextNode = new Node(element);
            previousNode.nextNode.nextNode = nextNode;
            numNodes++;
        }
    }

    public void addFirst(E element) {
        final Node<E> oldHead = headNode;
        final Node<E> newNode = new Node<>(element);
        headNode = newNode;
        newNode.nextNode = oldHead;
        numNodes++;
    }

    public void printList() {
        Node current = headNode;
        while (current != null) {
            System.out.println(current.element);
            current = current.nextNode;
        }
    }
}
