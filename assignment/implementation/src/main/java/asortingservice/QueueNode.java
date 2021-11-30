package asortingservice;

public class QueueNode<E> {
    E item;
private     QueueNode<E> next;

    /**
     * create new LL node
     *
     * @param item
     */
    public QueueNode(E item, QueueNode<E> next) {
        this.item = item;
        this.next = next;
    }

    public QueueNode<E> getNext() {
        return next;
    }

    public void setNext(QueueNode<E> next) {
        this.next = next;
    }
}
