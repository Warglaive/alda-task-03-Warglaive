package asortingservice;

import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

public class SortingServiceFactoryImpl implements sortingservice.SortingServiceFactory {
    @Override
    public <T> Queue<T> createPreferredQueue(SortKind forSorter) {
        switch (forSorter) {
            case INSERTION:
                //TODO: Continue
                return new QueueImpl<>();

            case SELECTION:
                //

                return new QueueImpl<>();

        }
        return null;
    }

    @Override
    public <T> Sorter<T> createSorter(SortKind kind, Comparator<T> comparator) {
        return null;
    }
}
