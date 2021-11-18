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
        E first;
        E next;

        E minimum;
        while (queue.iterator().hasNext()) {
            //TODO:Find minimum element using the comparator
            //compare first 2 elements to start with
            first = (E) queue.get();
            next = (E) queue.iterator().next();
            //find smaller element;
            //1 == first > next, -1 == first < next
            if (this.comparator.compare(first, next) == -1) {
                minimum = first;
            } else if (this.comparator.compare(first, next) == 1) {
                minimum = next;
            } else {
                //Does not matter
                minimum = first;
            }
            //Put minimum at start and next after it
            queue.put(minimum);

        }
        var sortedQueue = new QueueImpl<>();


        return sortedQueue;
    }
}
