package asortingservice;

public class Node<E> {
    E item;
    //previous
    private Node<E> right;
    //next
    private Node<E> left;
    public long size;

    /**
     * create new LL node
     *
     * @param item
     */

    Node(E item, Node<E> next) {
        this.item = item;
        this.right = next;
        this.left = null;
    }

    public Node(E item, int size) {
        this.item = item;
        this.size = size;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
