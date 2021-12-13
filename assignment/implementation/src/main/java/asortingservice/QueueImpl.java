package asortingservice;

import sortingservice.Queue;

import java.util.Iterator;

public class QueueImpl<E> implements Queue<E> {
    private Node head;
    private Node tail;
    int size;

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    @Override
    public void put(E item) {
        //create new node containing the item
        Node<E> tempNode = new Node<>(item);
        // If queue is empty, then new node is start and last both
        if (isEmpty()) {
            this.head = this.tail = tempNode;
        } else {
            // Add the new node at the end of queue and change last
            //TODO: debug if lastNode has element and next is proper
            this.tail.setNext(tempNode);
            tempNode.setPrevious(this.tail);
            this.tail = tempNode;
            //increment size
        }

        this.size++;

    }

    @Override
    public E get() {
        if (isEmpty()) {
            return null;
        }

        E item = (E) this.head.item;

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = this.head.next;
        }

        this.size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    @Override
    public long size() {
        return this.size;
    }

//    public void exchangePlaces(Node a, Node b) {
//        Node newNode = a;
//        E aux = (E) a.item;
//        a.item = b.item;
//        b.item = aux;
//        a.next = b;
//        b.previous = a;
//        if (a.previous != null) {
//            a.previous.next = a;
//        }
//        if (b.next != null) {
//            b.next.previous = b;
//        }
//    }

    public void exchangeItem(Node a, Node b) {
        E aux = (E) a.item;
        a.item = b.item;
        b.item = aux;
    }

//    public void addInTheFront(E item) {
//        Node itemNode = new Node(item);
//        Node currHead = this.head;
//        this.head = itemNode;
//        itemNode.next = currHead;
//        this.size++;
//    }

    class IteratorClass implements Iterator<E>{
        Node newNode;
        @Override
        public boolean hasNext() {
            if (getHead() != null && newNode == null) {
                return true;
            } else if(newNode != null && newNode.next != null){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            if (getHead() != null && newNode == null) {
                newNode = getHead();
                E a;
                a = (E) newNode.item;
                return a;
            }
            else if(newNode != null){
                if(newNode.next == null) {
                    throw new NullPointerException("There is no next in the queue!");
                }
                E a;
                newNode = newNode.next;
                a = (E) newNode.item;
                return a;
            }
            throw new NullPointerException("There is no next in the queue!");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorClass();
    }
}
