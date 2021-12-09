package sortingservice;

/**
 * A sorter sorts it input.
 * <p>
 * The implementation is expected to return the <b>same</b> queue instance.
 *
 * @param <T> type of elements in queue.
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public interface Sorter<T> {

    /**
     * Return the input queue in sorted order, the order being imposed by the
     * {@code Comparator<E>} provide by the constructor.
     *
     * @param q to be sorted
     * @return the queue with the elements in non-descending order as per the comparator.
     */
    Queue<T> sort(Queue<T> q);

}
