package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

public class SorterImpl<T> implements Sorter<T> {
    @Override
    public Queue<T> sort(Queue<T> queue) {
        //TODO: Sort the queue
        return queue.forEach(x->x.);
        return null;
    }
}
