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

        E minItem;
        // Traverse the List
        while (headNode != null) {
            //Get head node and next node
            QueueNode<E> tempNode = impl.headNode;
            //Node to save results to
            QueueNode<E> resultNode = new QueueNode<>(impl.get(), impl.headNode);
            // QueueNode<E> nextNode = headNode.next;
            // Traverse the unsorted sublist
            while (tempNode.getNext() != null) {
                //start at next node

                var firstItem = tempNode.item;
                var nextItem = tempNode.getNext().item;

                if (this.comparator.compare(firstItem, nextItem) > 0) {
                    minItem = nextItem;
                } else if (this.comparator.compare(firstItem, nextItem) < 0) {
                    continue;
                } else {
                    minItem = firstItem;
                }
                //Swap data
                E maxItem = tempNode.item;
                tempNode.item = minItem;
                tempNode.getNext().item = maxItem;
                //add new values to result node

                //go to next node (temp.next)
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
