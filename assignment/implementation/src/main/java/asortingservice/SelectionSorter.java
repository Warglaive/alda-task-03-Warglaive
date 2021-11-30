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
            QueueNode<E> minNode = impl.headNode;
            //Node to save results to
            QueueNode<E> resultNode = new QueueNode<>(impl.get(), impl.headNode);
            // QueueNode<E> nextNode = headNode.next;
            // Traverse the unsorted sublist
            int currentNodeIndex = 0;
            while (minNode.next != null) {
                //start at next node

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
                //Swap data
                E maxItem = minNode.item;
                resultNode.item = minItem;
                resultNode.next.item = maxItem;


                //get next 2 by iterating the minNode(tempNode)
                //TODO: Add out of bounds check
                for (int i = 0; i < 1; i++) {
                    minNode = minNode.next;
                    //TODO: fix
                }
                currentNodeIndex++;
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
