package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class InsertionSorter<E> implements Sorter<E> {
    private Comparator<E> comparator;

    public InsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> queue) {
        Node<E> sorted = null;
        //get head node
        Node<E> current = ((QueueImpl<E>) queue).getHeadNode();
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node<E> next = current.getNext();
            // insert current in sorted linked list
            sorted = sortedInsert(current, sorted);
            // Update current
            current = next;

        }
        var tempHeadNode = ((QueueImpl<E>) queue).getHeadNode();
        var tempTailNode = ((QueueImpl<E>) queue).getTailNode();
        ((QueueImpl<E>) queue).setHeadNode(tempTailNode);
         ((QueueImpl<E>) queue).setTailNode(tempHeadNode);

        return queue;
    }

    private Node<E> sortedInsert(Node<E> newNode, Node<E> sorted) {
        /* Special case for the head end */
        if (sorted == null || this.comparator.compare(sorted.item, newNode.item) > 0) {
            newNode.setNext(sorted);
            sorted = newNode;
        } else {
            Node<E> current = sorted;
            /* Locate the node before the point of insertion */
            while (current.getNext() != null && this.comparator.compare(sorted.item, newNode.item) < 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        return sorted;
    }
}
