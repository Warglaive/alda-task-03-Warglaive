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
            Map.of(SortKind.SELECTION, () -> new QueueImpl(),
                    SortKind.INSERTION, () -> new QueueImpl());

    //TODO: Add more queue types kinds when ready
    Map<SortKind, Function<Comparator, Sorter>> sorterMap = Map.of(
            SortKind.SELECTION, (comparator) -> new SelectionSorter(comparator)
            , SortKind.INSERTION, (comparator -> new InsertionSorter(comparator)));

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
                SortKind.SELECTION/*,
                SortKind.INSERTION*/
        };
    }
}
