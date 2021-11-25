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
        QueueImpl<E> impl = (QueueImpl<E>) queue;
        //1. Get head node and save to temp var


        //Get head node and next node
        QueueNode<E> temp = impl.getHeadNode();
        QueueNode<E> r = temp.next;


        E minItem;

        // Traverse the List
        while (temp != null) {
            QueueNode min = temp;
            // Traverse the unsorted sublist
            while (temp.next != null) {
                var firstItem = impl.getHeadNode().item;
                var nextItem = r.item;


                if (this.comparator.compare(firstItem, nextItem) > 0) {
                    minItem = nextItem;
                } else if (this.comparator.compare(firstItem, nextItem) < 0) {
                    minItem = firstItem;
                } else {
                    minItem = firstItem;
                }
                //Swap data
                E firstItemTemp = temp.item;
                temp.item = minItem;
                temp.next.item = firstItemTemp;
               // impl=temp;
            }
        }

        return (Queue<E>) temp;
    }

    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
