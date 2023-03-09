package mylinkedlist_same_linkedlist;

public class MyLinkedList<E> {
    private Node head;
//    private Node tail;
    private int numNodes;
    public MyLinkedList(){
    }
    public MyLinkedList(E[] elementsData){
        head = new Node(elementsData);
        numNodes++;
    }
    private class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
    public void add(int index, E element){
        if (index >= 0 && index <= numNodes){
            for (int i = 0; i < index; i++){

            }
        }
    }
    public void addFirst(E element){
        final Node<E> oldHead = head;
        final Node<E> newNode = new Node<>(element);
        head = newNode;
        newNode.next = oldHead;
        numNodes++;
    }

}
