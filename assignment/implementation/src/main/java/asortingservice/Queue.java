package asortingservice;

import java.util.Iterator;

public class Queue<E> implements sortingservice.Queue<E> {
    QueueNode<E> firstNode;
    QueueNode<E> lastNode;
    int size;

    public Queue() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
        System.out.println();
    }


    /**
     * enqueue
     *
     * @param item element to add
     */
    @Override
    public void put(E item) {
        //create new node containing the item
        QueueNode<E> tempNode = new QueueNode<>(item);
        // If queue is empty, then new node is start and last both
        if (isEmpty()) {
            /*this.firstNode = this.lastNode = tempNode;*/
            this.firstNode = this.lastNode;
            this.lastNode = tempNode;
            return;
        }
        // Add the new node at the end of queue and change last
        this.lastNode.next = tempNode;
        this.lastNode = tempNode;
        //increment size
        this.size++;
    }

    /**
     * dequeue
     *
     * @return
     */
    @Override
    public E get() {
        // If queue is empty, return NULL.
        if (isEmpty()) {
            return null;
        }
        // Store previous start and move start one node ahead
        QueueNode<E> tempNode = this.firstNode;
        this.firstNode = this.firstNode.next;
        // If front becomes NULL, then change rear also as NULL
        if (this.firstNode == null) {
            this.lastNode = null;
        }
        //TODO: may be wrong
        //return
        return tempNode.item;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
