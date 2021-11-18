package asortingservice;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;
import sortingservice.SortingServiceFactory;

public class SortingServices implements SortingServiceFactory {
    Map<SortKind, Supplier<Queue>> queueMap =
            Map.of(SortKind.SELECTION, () -> new QueueImpl());

    Map<SortKind, Function<Comparator, Sorter>> sorterMap = Map.of(SortKind.SELECTION, (comparator)
            -> new SelectionSorter(comparator));

    @Override
    public Queue createPreferredQueue(SortKind forSorter) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> Sorter<T> createSorter(SortKind kind, Comparator<T> comparator) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
