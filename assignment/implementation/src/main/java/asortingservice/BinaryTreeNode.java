package asortingservice;

import java.util.Comparator;

/**
 * I know I could use the Node class but to make my life easier, I'm going to use this for the last sorter.
 * S.S
 *
 * @param <E>
 */
public class BinaryTreeNode<E extends Comparable<E>> {
    E key;
    BinaryTreeNode<E> leftNode;
    BinaryTreeNode<E> rightNode;

    BinaryTreeNode(E key) {
        this.key = key;
        this.leftNode = null;
        this.rightNode = null;
    }

    BinaryTreeNode(E key, Node<E> next) {
        this.key = key;
        //TODO: Assign next
    }

    public void addRecursive(BinaryTreeNode<E> current, E key) {
        if (key.compareTo(current.key) < 0) {
            if (current.leftNode == null) {
                current.leftNode = new BinaryTreeNode<>(key);
            } else {
                addRecursive(current.leftNode, key);
            }
        } else {
            if (current.rightNode == null) {
                current.rightNode = new BinaryTreeNode<>(key);
            } else {
                addRecursive(current.rightNode, key);
            }
        }
    }
}
