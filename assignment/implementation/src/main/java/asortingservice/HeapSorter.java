package asortingservice;

import sortingservice.Queue;
import sortingservice.Sorter;

import java.util.Comparator;

public class HeapSorter<E> implements Sorter<E> {
    private final Comparator<E> comparator;
    Stack<Node<E>> parentStack;
    Node<E> root;
    int size;

    public HeapSorter(Comparator<E> comparator) {
        this.comparator = comparator;
        parentStack = new Stack<>();
        size = 1;
    }

    /**
     * cut last element
     * @param r
     * @param queue
     * @return
     */
    public Queue<E> sortingTree(Node<E> r, Queue<E> queue) {
        //sort operations count
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

    /**
     * Exchange Nodes and delete useless node
     *
     * @param opCount
     * @param lastNode
     * @param firstNode
     * @param parentNode
     * @return
     */
    public Node<E> ExchangeAndDelete(int opCount, Node<E> lastNode, Node<E> firstNode, Node<E> parentNode) {
        if (lastNode != null) {
            if (lastNode.size == opCount / 2)
                //find parent node
                parentNode = lastNode;
            if (lastNode.size == opCount) {
                E temp = firstNode.item;
                firstNode.item = lastNode.item;
                lastNode.item = temp;
                //Exchange and delete with firstIndex
                if (parentNode.getRight() != null && lastNode.item == parentNode.getRight().item) {
                    parentNode.setRight(null);

                } else {
                    parentNode.setLeft(null);
                }
                return firstNode;
            } else {
                Node<E> currNode = ExchangeAndDelete(opCount, lastNode.getRight(), firstNode, parentNode);
                if (currNode == null) {
                    currNode = ExchangeAndDelete(opCount, lastNode.getLeft(), firstNode, parentNode);
                }
                return currNode;
            }
        } else {
            return null;
        }

    }

    public boolean less(Node<E> firstNode, Node<E> secondNode) {
        return comparator.compare(firstNode.item, secondNode.item) < 0;

    }

    /**
     * Exchange Nodes
     * @param firstNode
     * @param secondNode
     */
    public void exchange(Node<E> firstNode, Node<E> secondNode) {
        E temp = firstNode.item;
        firstNode.item = secondNode.item;
        secondNode.item = temp;
    }

    public void sink(Node<E> parent) {
        //if left is smaller exchange
        if (parent.getRight() != null && less(parent.getRight(), parent)) {
            exchange(parent, parent.getRight());
        }
        //if right is smaller exchange
        if (parent.getLeft() != null && less(parent.getLeft(), parent)) {
            exchange(parent, parent.getLeft());

        }
        if (parent.getRight() != null) {
            sink(parent.getRight());
        }
        if (parent.getLeft() != null) {
            sink(parent.getLeft());
        }
    }


    @Override
    public Queue<E> sort(Queue<E> queue) {
        if (queue.isEmpty() || queue.size() == 1) {
            return queue;
        }
        makeTree(queue);
        Node<E> minHeapifyRoot = minHeapify();
        return sortingTree(minHeapifyRoot, queue);

    }

    /**
     * Rearrange a heap to maintain the heap property,
     * that is, the key of the root node is more extreme (greater or less) than or equal to the keys of its children.
     * @return
     */
    public Node<E> minHeapify() {
        while (parentStack.size > 0) {
            Node<E> parent = parentStack.peek();
            parentStack.pop();

            this.sink(parent);

        }
        return root;
    }

    public void makeTree(Queue<E> queue) {
        E item = queue.get();
        root = new Node<>(item, size);
        QueueImpl<Node<E>> availableParents = new QueueImpl<>();
        availableParents.put(root);

        while (!queue.isEmpty()) {
            Node<E> availableParent = availableParents.get();
            E currItem = queue.get();
            Node<E> leftCurrent = new Node<>(currItem, ++size);
            availableParent.setRight(leftCurrent);
            parentStack.push(availableParent);
            availableParents.put(leftCurrent);

            if (!queue.isEmpty()) {
                E currItemR = queue.get();
                Node<E> rightCurrent = new Node<>(currItemR, ++size);
                availableParent.setLeft(rightCurrent);
                availableParents.put(rightCurrent);
            }
        }
    }
}
