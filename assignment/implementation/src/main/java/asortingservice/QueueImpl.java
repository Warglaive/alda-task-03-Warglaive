package asortingservice;

import sortingservice.Queue;

import java.util.Iterator;

public class QueueImpl<E> implements Queue<E> {

    private Node headNode;
    private Node tailNode;
    private long size;

    QueueImpl() {
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
        Node<E> tempNode = new Node<>(item, null);
        // If queue is empty, then new node is start and last both
        if (isEmpty()) {
            this.headNode = this.tailNode = tempNode;
        } else {
            // Add the new node at the end of queue and change last
            //TODO: debug if lastNode has element and next is proper
            this.tailNode.setNext(tempNode);
            this.tailNode = tempNode;
            //increment size
        }
        this.size++;
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
        Node<E> tempNode = this.headNode;
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

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public long size() {
        return this.size;
    }

    public E peek() {
        // If queue is empty, return NULL.
        if (isEmpty()) {
            return null;
        }
        return (E) this.headNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        //TODO: Implement

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return headNode != tailNode;
            }

            @Override
            public E next() {
                //TODO: May be wrong
                return (E) headNode.getNext();
            }

        };
    }

    public Node<E> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<E> headNode) {
        this.headNode = headNode;
    }

    public Node<E> getTailNode() {
        return tailNode;
    }

    public void setTailNode(Node<E> tailNode) {
        this.tailNode = tailNode;
    }
}