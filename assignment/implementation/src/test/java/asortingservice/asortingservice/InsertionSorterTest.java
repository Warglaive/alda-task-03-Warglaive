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
        Queue<Integer> queue = this.factory.createPreferredQueue(SortKind.INSERTION);
        //hardcoded elementsCount value for test purposes
        queue = fillRandom(queue, 5);
        Queue<Integer> sortedQueue = this.sorter.sort(queue);
        assertThat(sortedQueue).isSameAs(queue);
    }

    Queue<Integer> fillRandom(Queue<Integer> unsortedQueue, int elementsCount) {
        //make unsorted queue
        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }
}