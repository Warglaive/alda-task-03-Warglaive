package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class SelectionSorter<E> implements Sorter<E> {
    private Comparator<E> comparator;

    SelectionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> queue) {
        QueueImpl<E> impl = (QueueImpl<E>) queue;
        //1. Get head node and save to temp var

        //Get head node and next node
        Node<E> headNode = impl.getHeadNode();
        //traverse the list
        while (headNode != null) {
            Node<E> minItemNode = headNode;
            Node<E> nextNode = headNode.getLeft();
            //Traverse the unsorted sublist
            while (nextNode != null) {
                //Find which node has the smallest element
                if (this.comparator.compare(minItemNode.item, nextNode.item) > 0) {
                    minItemNode = nextNode;
                }
                //go to next node
                nextNode = nextNode.getLeft();
            }
            //swap elements
            E tempItem = headNode.item;
            headNode.item = minItemNode.item;
            minItemNode.item = tempItem;
            headNode = headNode.getLeft();
        }

        return queue;
    }

   /* @Override
    public int compareTo(E b) {
        //TODO: MAy be buggy
        return this.comparator.compare((E) this, b);
    }*/

}
