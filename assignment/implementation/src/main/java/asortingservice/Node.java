package asortingservice;

public class Node<E> {
    E item;
    private Node<E> next;

    /**
     * create new LL node
     *
     * @param item
     */
    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
