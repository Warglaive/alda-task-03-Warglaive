package asortingservice;

public class Stack <E>{
    Node<E> head = null;
    int size;

    public static class Node<T> {

        T item;
        Node<T> previous;

        public Node(T item, Node<T> previous) {
            this.item = item;
            this.previous = previous;
        }

        public Node<T> getPrevious() {
            return previous;
        }
    }

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

        this.head = this.head.getPrevious();
    }

    public E peek() {
        if (this.head == null) {
            throw new NullPointerException("Stack is empty");
        }
        return this.head.item;
    }

    public int size(){
        return size;
    }
}
