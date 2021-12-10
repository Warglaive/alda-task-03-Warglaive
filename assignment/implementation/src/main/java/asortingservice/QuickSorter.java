package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class QuickSorter<E> implements Sorter<E> {
    private Comparator<E> comparator;

    public QuickSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> queue) {
        // Get first and last node
        Node<E> first = ((QueueImpl<E>) queue).getHeadNode();
        Node<E> last = ((QueueImpl<E>) queue).getTailNode();
        quickSort(first, last);
        return queue;
    }

    private void quickSort(Node<E> first, Node<E> last) {
        // Check first and last node valid or not
        if (first != last
                && first != null
                && last != null
                && last.getNext() != first) {
            //
            Node<E> node = this.partition(first, last);
            if (node != null) {
                // Recursively sort elements
                this.quickSort(node.getNext(), last);
                this.quickSort(first,node.getPrevious());
            }
        }
    }

    // Get partition node
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
                //swap node values
                temp = current.item;
                current.item = location.item;
                location.item = temp;
            }
            //visit to next node
            current = current.getNext();
        }
        if (location == null) {
            location = first;
        } else {
            location = location.getNext();
        }
        //swap node values
        temp = last.item;
        last.item = location.item;
        location.item = temp;
        return location;
    }
}
