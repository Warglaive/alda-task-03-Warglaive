package asortingservice;

/**
 * I know I could use the Node class but to make my life easier, I'm going to use this for the last sorter.
 * S.S
 *
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {
    E key;
    Node<E> rootNode;

    BinaryTree(E key) {
        this.key = key;
        this.rootNode = null;
    }

    BinaryTree(E key, Node<E> next) {
        this.key = key;
        //TODO: Assign next
    }

    public Node<E> addRecursive(Node<E> current, E key) {
        if (current == null) {
            return new Node<E>(key);
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
