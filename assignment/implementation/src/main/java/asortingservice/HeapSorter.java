package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class HeapSorter<E> implements Sorter<E> {
    private final Comparator<E> comparator;
    Stack<Node<E>> parentStack;
    Node<E> root;
    int size;

    public Queue sortingTree(Node<E> r, Queue<E> queue) {

        int count = size;
        while (count > 1) {
            //put root
            queue.put(r.item);
            //exchange root to last item and delete it
            ExchangeAndDelete(count, r, r, r);

            //sink root
            sink(r);
            count--;
        }
        queue.put(r.item);

        return queue;
    }


    public Node<E> ExchangeAndDelete(int i, Node<E> lastNode, Node<E> firstNode, Node<E> parentNode) {
        if (lastNode != null) {
            if (lastNode.size == i / 2)
                //find parent node
                parentNode = lastNode;
            if (lastNode.size == i) {
                E aux = firstNode.item;
                firstNode.item = lastNode.item;
                lastNode.item = aux;
                //Exchange and delete with firstIndex
                if (parentNode.getLeft() != null && lastNode.item == parentNode.getLeft().item) {
                    parentNode.setLeft(null);

                } else {
                    parentNode.setRight(null);
                }
                return firstNode;
            } else {
                Node<E> currNode = ExchangeAndDelete(i, lastNode.getLeft(), firstNode, parentNode);
                if (currNode == null) {
                    currNode = ExchangeAndDelete(i, lastNode.getRight(), firstNode, parentNode);
                }
                return currNode;
            }
        } else {
            return null;
        }

    }

    public HeapSorter(Comparator comparator) {
        this.comparator = comparator;
        parentStack = new Stack<>();
        size = 1;
    }

    public boolean less(Node<E> firstNode, Node<E> secondNode) {
        return comparator.compare(firstNode.item, secondNode.item) < 0;

    }

    public void exchange(Node<E> firstNode, Node<E> secondNode) {
        E aux = firstNode.item;
        firstNode.item = secondNode.item;
        secondNode.item = aux;
    }

    public void sink(Node<E> parent) {
        //if left is smaller exchange
        if (parent.getLeft() != null && less(parent.getLeft(), parent)) {
            exchange(parent, parent.getLeft());
        }
        //if right is smaller exchange
        if (parent.getRight() != null && less(parent.getRight(), parent)) {
            exchange(parent, parent.getRight());

        }
        if (parent.getLeft() != null) {
            sink(parent.getLeft());
        }
        if (parent.getRight() != null) {
            sink(parent.getRight());
        }
    }


    @Override
    public Queue<E> sort(Queue<E> queue) {

        if (queue.isEmpty() || queue.size() == 1) return queue;
        Tree(queue);
        Node<E> minHeapify = minHeapify();
        return sortingTree(minHeapify, queue);

    }

    public Node<E> minHeapify() {

        while (parentStack.size > 0) {
            Node<E> parent = parentStack.peek();
            parentStack.pop();

            this.sink(parent);

        }
        return root;

    }

    public Node<E> Tree(Queue<E> queue) {

        E item = queue.get();
        root = new Node<E>(item, size);
        QueueImpl<Node<E>> availableParents = new QueueImpl<>();
        availableParents.put(root);

        while (!queue.isEmpty()) {

            Node<E> availableParent = availableParents.get();
            E currItem = queue.get();
            Node<E> leftCurrent = new Node<>(currItem, ++size);
            availableParent.setLeft(leftCurrent);
            parentStack.push(availableParent);
            availableParents.put(leftCurrent);

            if (!queue.isEmpty()) {
                E currItemR = queue.get();
                Node<E> rightCurrent = new Node<>(currItemR, ++size);
                availableParent.setRight(rightCurrent);
                availableParents.put(rightCurrent);

            }

        }
        return root;

    }
}
