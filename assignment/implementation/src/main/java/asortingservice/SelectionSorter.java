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
        QueueNode<E> headNode = impl.headNode;
        //traverse the list
        while (headNode != null) {
            QueueNode<E> minItemNode = headNode;
            QueueNode<E> nextNode = headNode.getNext();
            //Traverse the unsorted sublist
            while (nextNode != null) {
                //Find which node has the smallest element
                if (this.comparator.compare(minItemNode.item, nextNode.item) > 0) {
                    minItemNode = nextNode;
                }
                //go to next node
                nextNode = nextNode.getNext();
            }
            //swap elements
            E tempItem = headNode.item;
            headNode.item = minItemNode.item;
            minItemNode.item = tempItem;
            headNode = headNode.getNext();
        }

        return queue;
    }

    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }
}
