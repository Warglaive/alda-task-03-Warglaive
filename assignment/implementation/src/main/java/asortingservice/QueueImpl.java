package asortingservice;

import sortingservice.Queue;

import java.util.Iterator;

public class QueueImpl<E> implements Queue<E> {
    QueueNode<E> headNode;
    QueueNode<E> tailNode;
    long size;

    public QueueImpl() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }


    /**
     * enqueue
     *
     * @param item element to add
     */
    @Override
    public void put(E item) {
        //create new node containing the item
        QueueNode<E> tempNode = new QueueNode<>(item, null);
        // If queue is empty, then new node is start and last both
        if (isEmpty()) {
            this.headNode = this.tailNode = tempNode;
            this.size++;
            return;
        } else {
            // Add the new node at the end of queue and change last
            //TODO: debug if lastNode has element and next is proper
            this.tailNode.setNext(tempNode);
            this.tailNode = tempNode;
            //increment size
            this.size++;
        }
    }

    /**
     * dequeue
     *
     * @return first node's element
     */
    @Override
    public E get() {
        // If queue is empty, return NULL.
        if (isEmpty()) {
            return null;
        }
        // Store previous start and move start one node ahead
        QueueNode<E> tempNode = this.headNode;
        this.headNode = this.headNode.getNext();
        // If first becomes NULL, then change last also as NULL
        if (this.headNode == null) {
            this.tailNode = null;
        }
        //TODO: may be wrong
        //return
        this.size--;
        return tempNode.item;
    }

    /*private E peek() {
        // If queue is empty, return NULL.
        if (isEmpty()) {
            return null;
        }
        return this.headNode.item;
    }*/

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public E peek() {
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        //TODO: Implement

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return headNode.getNext() != tailNode;
            }

            @Override
            public E next() {
                //TODO: May be wrong
                return (E) headNode.getNext();
            }
        };
    }
}
