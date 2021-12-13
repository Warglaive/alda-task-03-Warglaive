package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class QuickSorter<E> implements Sorter<E> {
    private final Comparator<E> comparator;

    public QuickSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> q) {
        Node<E> first = ((QueueImpl<E>) q).getHead();
        Node<E> last = ((QueueImpl<E>) q).getTail();
        quickSort(first, last);
        return q;
    }

    private void quickSort(Node<E> first, Node<E> last) {
        if (first != last
                && first != null
                && last != null
                && last.getNext() != first) {
            Node<E> node = this.partition(first, last);
            if (node != null) {
                this.quickSort(node.getNext(), last);
                this.quickSort(first,node.getPrevious());
            }
        }
    }

    public Node<E> partition(Node<E> first, Node<E> last) {
        Node<E> current = first;
        Node<E> location = first.getPrevious();
        E temp = null;
        while (current != null && current != last) {
            if (this.comparator.compare(current.item, last.item) < 0) {
                if (location == null) {
                    location = first;
                } else {
                    location = location.getNext();
                }
                temp = current.item;
                current.item = location.item;
                location.item = temp;
            }
            current = current.getNext();
        }
        if (location == null) {
            location = first;
        } else {
            location = location.getNext();
        }

        temp = last.item;
        last.item = location.item;
        location.item = temp;
        return location;
    }
}
