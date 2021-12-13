package asortingservice;

public class Node<E> {
    E item;
    Node next;
    Node previous;

    public Node(E item) {
        this.item = item;
        this.next = null;
    }

    public Node(Node node) {
        this.item = (E) node.item;
        this.next = node.next;
        this.previous = node.previous;
    }

    public E getItem() {
        return this.item;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
