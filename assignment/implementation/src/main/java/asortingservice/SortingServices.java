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
    Map<SortKind, Supplier<Queue>> queueMap = Map.of(
            SortKind.SELECTION, QueueImpl::new,
            SortKind.INSERTION, QueueImpl::new,
            SortKind.QUICK, QueueImpl::new,
            SortKind.HEAP, QueueImpl::new);

    Map<SortKind, Function<Comparator, Sorter>> sorterMap = Map.of(
            SortKind.SELECTION, SelectionSorter::new,
            SortKind.INSERTION, InsertionSorter::new,
            SortKind.QUICK, QuickSorter::new,
            SortKind.HEAP, QuickSorter::new);

    @Override
    public Queue createPreferredQueue( SortKind forSorter ) {
        return queueMap.get( forSorter ).get();
    }

    @Override
    public <T> Sorter<T> createSorter( SortKind kind, Comparator<T> comparator ) {
        return sorterMap.get(kind).apply(comparator);
    }

    @Override
    public SortKind[] supportedSorters() {
        return new SortKind[]{
                SortKind.SELECTION,
                SortKind.INSERTION,
                SortKind.QUICK,
                SortKind.HEAP
        };
    }
}
