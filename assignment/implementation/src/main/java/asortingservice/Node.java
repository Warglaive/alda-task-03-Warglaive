package asortingservice;

public class Node<E> {
    E item;
    private Node<E> left;
    private Node<E> right;
    public long size;

    /**
     * create new LL node
     *
     * @param item
     */

    Node(E item, Node<E> next) {
        this.item = item;
        this.left = next;
        this.right = null;
    }

    public Node(E item, int size) {
        this.item = item;
        this.size = size;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }
}
