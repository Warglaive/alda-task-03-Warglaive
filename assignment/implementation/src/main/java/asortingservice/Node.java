package asortingservice;

public class Node<E> {
    E item;
    private Node<E> next;
    private Node<E> previous;

    /**
     * create new LL node
     *
     * @param item
     */

    Node(E item) {
        this.item = item;
        this.next = null;
        this.previous = null;

    }

    Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
        this.previous = null;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
