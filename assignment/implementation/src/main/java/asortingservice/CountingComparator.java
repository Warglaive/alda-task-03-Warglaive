package asortingservice;

import java.util.Comparator;

public class CountingComparator<T> implements Comparator<T> {
    private final Comparator<T> wrapped;

    public CountingComparator(Comparator<T> wrapped) {
        this.wrapped = wrapped;
    }


    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}
