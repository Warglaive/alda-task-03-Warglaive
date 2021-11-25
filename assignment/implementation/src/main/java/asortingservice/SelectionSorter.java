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

        QueueNode<E> headNode = impl.headNode;
        //QueueNode<E> r = headNode.next;

        E minItem;

        // Traverse the List
        while (headNode != null) {
            //Get head node and next node
            QueueNode<E> minNode = impl.headNode;
            // QueueNode<E> nextNode = headNode.next;
            // Traverse the unsorted sublist
            while (minNode.next != null) {
                var firstItem = minNode.item;
                var nextItem = minNode.next.item;

                if (this.comparator.compare(firstItem, nextItem) > 0) {
                    minItem = nextItem;
                    //minNode = nextNode;
                } else if (this.comparator.compare(firstItem, nextItem) < 0) {
                    continue;
                } else {
                    minItem = firstItem;
                }
                //nextNode = headNode;
                //Swap data
                E firstItemTemp = minNode.item;
                minNode.item = minItem;
                minNode.next.item = firstItemTemp;
                // impl=temp;
                // headNode = minNode;
                //start at next node
                minNode = minNode.next;
            }
            ((QueueImpl<E>) queue).headNode = headNode;
        }

        return queue;
    }

    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
