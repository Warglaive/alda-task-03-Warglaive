package asortingservice;

public class Stack<E> {
    Node<E> head = null;
    int size;

    public Stack() {
    }

    public void push(E item) {
        this.head = new Node<>(item, this.head);
        size++;
    }

    public void pop() {
        if (this.head == null) {
            throw new NullPointerException("Stack is empty");
        }
        size--;

        this.head = this.head.getLeft();
    }

    public E peek() {
        if (this.head == null) {
            throw new NullPointerException("Stack is empty");
        }
        return this.head.item;
    }

}
