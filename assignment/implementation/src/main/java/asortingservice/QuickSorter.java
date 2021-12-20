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
                && last.getRight() != first) {
            //
            Node<E> node = this.partition(first, last);
            if (node != null) {
                // Recursively sort elements
                this.quickSort(node.getRight(), last);
                this.quickSort(first, node.getLeft());
            }
        }
    }

    // Get partition node
    public Node<E> partition(Node<E> first, Node<E> last) {
        Node<E> current = first;
        //location or pivot
        Node<E> pivot = first.getLeft();
        E temp = null;
        //set pivot
        while (current != null && current != last) {
            var test = this.comparator.compare(current.item, last.item);
            if (this.comparator.compare(current.item, last.item) < 0) {
                if (pivot == null) {
                    pivot = first;
                } else {
                    pivot = pivot.getRight();
                }
                //swap node values
                temp = current.item;
                current.item = pivot.item;
                pivot.item = temp;
            }
            //visit to next node
            current = current.getRight();
        }
        if (pivot == null) {
            pivot = first;
        } else {
            pivot = pivot.getRight();
        }
        //swap node values
        temp = last.item;
        last.item = pivot.item;
        pivot.item = temp;
        return pivot;
    }
}
