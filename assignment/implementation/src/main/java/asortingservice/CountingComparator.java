package asortingservice;

import java.util.Comparator;
import java.util.concurrent.atomic.LongAdder;

public class CountingComparator<T> implements Comparator<T> {
    private final Comparator<T> wrapped;
    private LongAdder count;

    public CountingComparator(Comparator<T> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public int compare(T o1, T o2) {
        this.count.increment();
        return wrapped.compare(o1, o2);
    }

    public long getCount() {
        return this.count.longValue();
    }

    public Comparator<T> getWrapped() {
        return wrapped;
    }
}
