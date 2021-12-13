package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class SelectionSorter<E> implements Sorter<E> {
    QueueImpl<E> queue = new QueueImpl<>();
    private Comparator comp;

    public SelectionSorter(Comparator<E> comp){
        this.comp = comp;
    }

    @Override
    public Queue<E> sort(Queue<E> q) {
        QueueImpl<E> impl = (QueueImpl<E>) q;
        Node<E> headNode = impl.getHead();
        while (headNode != null) {
            Node<E> minItemNode = headNode;
            Node<E> nextNode = headNode.getNext();
            while (nextNode != null) {
                if (this.comp.compare(minItemNode.item, nextNode.item) > 0) {
                    minItemNode = nextNode;
                }
                nextNode = nextNode.getNext();
            }
            E tempItem = headNode.item;
            headNode.item = minItemNode.item;
            minItemNode.item = tempItem;
            headNode = headNode.getNext();
        }

        return q;
    }
}
