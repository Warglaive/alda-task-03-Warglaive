package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class SelectionSorter<E> implements Sorter<E> {
    CountingComparator<E> comparator;

    public SelectionSorter(Comparator<E> comparator) {
        this.comparator = (CountingComparator<E>) comparator;
    }

    @Override
    public Queue sort(Queue queue) {
        var tempQueue = new QueueImpl<>();


        var sortedQueue = new QueueImpl<>();
        //compare first 2 elements to start with
        //TODO: Sort the queue
        long numOfElements = queue.size();
        for (int i = 0; i < numOfElements; i++) {
            //TODO:Find minimum element using the comparator

        }

        return sortedQueue;
    }
}
