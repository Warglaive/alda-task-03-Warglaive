package asortingservice;

import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;
import sortingservice.SortingServiceFactory;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class SortingServices implements SortingServiceFactory {
    Map<SortKind, Supplier<Queue>> queueMap =
            Map.of(SortKind.SELECTION, QueueImpl::new,
                    SortKind.QUICK, QueueImpl::new,
                    SortKind.INSERTION, QueueImpl::new
                    , SortKind.HEAP, QueueImpl::new);

    //TODO: Add more queue types kinds when ready
    Map<SortKind, Function<Comparator, Sorter>> sorterMap = Map.of(
            SortKind.SELECTION, SelectionSorter::new
            , SortKind.INSERTION, InsertionSorter::new
            , SortKind.QUICK, QuickSorter::new
            , SortKind.HEAP, HeapSorter::new);

    //TODO: Add more sorter kinds when ready

 /*   public SortingServices() {
        this.sorterMap.put(Map.of(SortKind.SELECTION, (comparator)
                -> new SelectionSorter(comparator)));
     *//*   this.sorterMap.put(SortKind.INSERTION, (comparator)
                -> new SelectionSorter(comparator));*//*
    }*/

    @Override
    public <T> Queue<T> createPreferredQueue(SortKind forSorter) {
        return this.queueMap.get(forSorter).get();
    }

    @Override
    public <T> Sorter<T> createSorter(SortKind kind, Comparator<T> comparator) {
        return this.sorterMap.get(kind).apply(comparator);
    }

    /**
     * @return array of supported(implemented) sorters
     */
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
