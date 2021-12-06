package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertionSorterTest {

    private SortingServices factory;
    private Comparator<Integer> comparator;
    private Sorter<Integer> sorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.comparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        this.sorter = this.factory.createSorter(SortKind.INSERTION, this.comparator);
    }

    @Test
    void sort() {
        //TODO: Fix Node's references
        Queue<Integer> unsortedQueue;
        //hardcoded elementsCount value for test purposes
        unsortedQueue = fillRandom(5);
        QueueImpl<Integer> sortedQueue = new QueueImpl<>();

        sortedQueue = (QueueImpl<Integer>) this.sorter.sort(unsortedQueue);
        assertThat(sortedQueue).isSameAs(unsortedQueue);
    }

    Queue<Integer> fillRandom(int elementsCount) {
        //make unsorted queue
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }
}