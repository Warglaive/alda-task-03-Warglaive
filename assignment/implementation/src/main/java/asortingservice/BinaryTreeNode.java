package asortingservice;

/**
 * I know I could use the Node class but to make my life easier, I'm going to use this for the last sorter.
 * S.S
 *
 * @param <E>
 */
public class BinaryTreeNode<E> {
    E key;
    BinaryTreeNode<E> leftNode;
    BinaryTreeNode<E> rightNode;

    BinaryTreeNode(E key) {
        this.key = key;
        this.leftNode = this.rightNode = null;
    }
}
