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
        Node<E> front = ((QueueImpl<E>) queue).getHead();
        Node<E> back = null;
        while (front != null) {
            back = front.getNext();
            while (back != null && back.getPrevious() != null
                    && this.comparator.compare(back.item, back.getPrevious().item) < 0) {
                ((QueueImpl<E>) queue).exchangeItem(back, back.getPrevious());
                back = back.getPrevious();
            }
            front = front.getNext();
        }
        return queue;
    }

}
