package asortingservice;

import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

public class SortingServiceFactory implements sortingservice.SortingServiceFactory{
    @Override
    public <T> Queue<T> createPreferredQueue(SortKind forSorter) {
        switch (forSorter){
            case INSERTION:
                //TODO: Continue
                return new asortingservice.Queue<>();
        }
        return null;
    }

    @Override
    public <T> Sorter<T> createSorter(SortKind kind, Comparator<T> comparator) {
        return null;
    }
}
