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
    }


    /**
     * enqueue
     *
     * @param item element to add
     */
    @Override
    public void put(E item) {
        QueueNode<E> tempNode = new QueueNode<>(item);
        this.size++;
    }

    /**
     * dequeue
     *
     * @return
     */
    @Override
    public E get() {
        return null;
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
