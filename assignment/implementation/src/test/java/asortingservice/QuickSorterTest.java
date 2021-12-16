package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuickSorterTest {
    private SortingServices factory;
    private Comparator<Integer> integerComparator;
    private Sorter<Integer> integerSorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        //Integer
        this.integerComparator = new CountingComparator<>(Integer::compareTo);
        this.integerSorter = this.factory.createSorter(SortKind.QUICK, this.integerComparator);
    }

    @Test
    void sort() {
        Queue<Integer> unsortedQueue = this.factory.createPreferredQueue(SortKind.QUICK);
        //hardcoded elementsCount value for test purposes
        unsortedQueue = fillUnsorted(5);
        var sortedQueue = new QueueImpl<Integer>();
        sortedQueue = (QueueImpl<Integer>) fillSorted(5);
        unsortedQueue = this.integerSorter.sort(unsortedQueue);
        for (int i = 0; i < unsortedQueue.size(); i++) {
            assertThat(unsortedQueue.get()).isEqualTo(sortedQueue.get());
        }

    }
    Queue<Integer> fillSorted(int elementsCount) {
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = 1; i <= elementsCount; i++) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }

    /**
     * helper
     *
     * @param elementsCount
     * @return
     */
    Queue<Integer> fillUnsorted(int elementsCount) {
        //make unsorted queue
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }
}