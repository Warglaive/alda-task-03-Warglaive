package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class HeapSorter<E> implements Sorter<E> {
    private Comparator<E> comparator;

    public HeapSorter(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> q) {

        //var headNode= q.
        return null;
    }
}
