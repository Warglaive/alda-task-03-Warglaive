package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SelectionSorterTest {
    private SortingServices factory;


    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
    }

    @Test
    void integerSortTest() {
        Queue<Integer> queue = factory.createPreferredQueue(SortKind.SELECTION);
        queue = fillRandom(queue, 50);
        Comparator<Integer> comp = new CountingComparator<>((a, b) -> a.compareTo(b));
        Sorter<Integer> sorter = factory.createSorter(SortKind.SELECTION, comp);
        Queue<Integer> sortedQueue = sorter.sort(queue);
        assertThat(sortedQueue).isSameAs(queue);

        // assertThat(sortedQueue).isOrderedAccoridingTo();
        // more tests.
    }

    Queue<Integer> fillRandom(Queue<Integer> unsortedQueue, int elementsCount) {
        //make unsorted queue

        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }
}