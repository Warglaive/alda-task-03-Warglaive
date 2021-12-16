/*
package asortingservice;


public class BinaryTree<E extends Comparable<E>> {
    E key;
    Node<E> rootNode;

    BinaryTree() {
    }

    public Node<E> addRecursive(Node<E> current, E key) {
        if (current == null) {
            return new Node<>(key);
        }

        if (key.compareTo(current.item) < 0) {
            current.setLeft(addRecursive(current.getLeft(), key));
        } else if (key.compareTo(current.item) > 0) {
            current.setRight(addRecursive(current.getRight(), key));
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    void add(E key) {
        this.addRecursive(this.rootNode, key);
    }
}
*/
