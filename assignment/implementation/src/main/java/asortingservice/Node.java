package asortingservice;

public class Node<E> {
    E item;
    private Node<E> left;
    private Node<E> right;

    /**
     * create new LL node
     *
     * @param item
     */

    Node(E item) {
        //used only in BinaryTree for now.
        this.item = item;
        this.left = null;
        this.right = null;

    }

    Node(E item, Node<E> next) {
        this.item = item;
        this.left = next;
        this.right = null;
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
