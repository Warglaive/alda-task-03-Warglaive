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
        //TODO: Sort the queue
        var tempQueue = new QueueImpl<>();

        //traverse the queue
        long numOfElements = queue.size();
        E element;
        while (queue.iterator().hasNext()) {
            //compare first 2 elements to start with
            //TODO:Find minimum element using the comparator

            element = (E) queue.get();
        }
        var sortedQueue = new QueueImpl<>();


        return sortedQueue;
    }
}
