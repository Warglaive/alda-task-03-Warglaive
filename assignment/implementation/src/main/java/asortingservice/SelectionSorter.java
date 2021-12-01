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
            QueueNode<E> tempNode = impl.headNode;
            //traverse the list
            while (tempNode != null) {
                QueueNode<E> minItemNode = tempNode;
                QueueNode<E> nextNode = tempNode.getNext();
                //Traverse the unsorted sublist
                while (nextNode != null) {
                    if (this.comparator.compare(minItemNode.item, nextNode.item) > 0) {
                        minItemNode = nextNode;
                    }
                    nextNode = nextNode.getNext();
                }
                //swap data
                E x = tempNode.item;
                tempNode.item = minItemNode.item;
                minItemNode.item = x;
                tempNode = tempNode.getNext();
            }
        }

        return queue;
    }

    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
