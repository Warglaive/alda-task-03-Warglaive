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
    public Queue<E> sort(Queue<E> queue) {
        //TODO: Sort the queue
        Queue<E> sortedQueue = new QueueImpl<>();

        //traverse the queue
        E first;
        E next;

        E minimum;
        while (queue.iterator().hasNext()) {
            //TODO:Find minimum element using the comparator
            //compare first 2 elements to start with
            first = (E) queue.peek();
            next = (E) queue.iterator().next();
            //find smaller element;
            //1 == first > next, -1 == first < next
            if (this.comparator.compare(first, next) < 0) {
                minimum = first;
            } else if (this.comparator.compare(first, next) > 0) {
                minimum = next;
            } else {
                //Does not matter
                minimum = first;
            }
            //Put minimum at start and next after it
            queue.put(minimum);
            sortedQueue = queue;
        }


        return sortedQueue;
    }

    @Override
    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
