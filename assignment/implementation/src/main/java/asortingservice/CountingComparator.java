package asortingservice;

import java.util.Comparator;
import java.util.concurrent.atomic.LongAdder;

public class CountingComparator<E> implements Comparator<E> {
    private final Comparator<E> wrapped;
    private final LongAdder count;

    public CountingComparator(Comparator<E> wrapped) {
        this.wrapped = wrapped;
        this.count = new LongAdder();
    }

    @Override
    public int compare(E o1, E o2) {
        this.count.increment();
        return wrapped.compare(o1, o2);
    }
}
