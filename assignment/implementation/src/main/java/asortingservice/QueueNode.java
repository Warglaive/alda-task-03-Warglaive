package asortingservice;

public class QueueNode<E> {
    E item;
    QueueNode<E> next;

    /**
     * create new LL node
     * @param item
     */
    public QueueNode(E item) {
        this.item = item;
        this.next = null;
    }
}
