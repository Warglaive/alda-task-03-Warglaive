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

        // E minItem = null;
        // Traverse the List
        while (headNode != null) {
            //Get head node and next node
            QueueNode<E> temp = impl.headNode;
            //traverse the list
            while (temp != null) {
                QueueNode<E> min = temp;
                QueueNode<E> r = temp.getNext();
                //Traverse the unsorted sublist
                while (r != null) {
                    if (this.comparator.compare(min.item, r.item) > 0) {
                        min = r;
                    }
                    r = r.getNext();
                }
                //swap data
                E x = temp.item;
                temp.item = min.item;
                min.item = x;
                temp = temp.getNext();
            }
        }

        return queue;
    }

    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
