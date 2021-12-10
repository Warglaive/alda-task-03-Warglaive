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
        
        return null;
    }
}
