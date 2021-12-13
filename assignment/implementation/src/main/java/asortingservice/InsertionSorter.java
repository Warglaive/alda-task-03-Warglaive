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
        // Get first node
        Node<E> front = ((QueueImpl<E>) queue).getHeadNode();
        Node<E> back = null;
        while (front != null) {
            //Get next node
            back = front.getLeft();
            // Update node value when consecutive nodes are not sort
            while (back != null && back.getRight() != null
                    && this.comparator.compare(back.item, back.getRight().item) < 0) {
                // Modified node data
                swapData(back, back.getRight());
                // Visit to previous node
                back = back.getRight();
            }
            // Visit to next node
            front = front.getLeft();
        }
        return queue;
    }

    public void swapData(Node<E> first, Node<E> second) {
        E value = first.item;
        first.item = second.item;
        second.item = value;
    }
}
