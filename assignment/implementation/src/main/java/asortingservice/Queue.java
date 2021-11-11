package asortingservice;

import java.util.Iterator;

public class Queue<E> implements sortingservice.Queue<E> {

    /**
     * enqueue
     *
     * @param t element to add
     */
    @Override
    public void put(E t) {

    }

    /**
     * dequeue
     *
     * @return
     */
    @Override
    public E get() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
