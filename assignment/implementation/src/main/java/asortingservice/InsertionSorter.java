package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class InsertionSorter<E> implements Sorter<E> {
    private Comparator<E> comparator;

    public InsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Queue<E> sort(Queue<E> queue) {
     /*   var queueImpl = (QueueImpl) queue;
        var sorted = new Node<>();
        Node headRef = queueImpl.getHeadNode();
        // sort a singly linked list using insertion sort
        void insertion_Sort (Node headRef){
            // initially, no nodes in sorted list so its set to null
            sorted = null;
            Node current = headRef;
            // traverse the linked list and add sorted node to sorted list
            while (current != null) {
                // Store current.next in next
                Node next = current.next;
                // current node goes in sorted list
                Insert_sorted(current);
                // now next becomes current
                current = next;
            }
            // update head to point to linked list
            head = sorted;
        }

        //insert a new node in sorted list
        void Insert_sorted (node newNode){
            //for head node
            if (sorted == null || sorted.val >= newNode.val) {
                newNode.next = sorted;
                sorted = newNode;
            } else {
                node current = sorted;
                //find the node and then insert
                while (current.next != null && current.next.val < newNode.val) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }*/
    }
}
