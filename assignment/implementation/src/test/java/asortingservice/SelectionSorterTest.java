package asortingservice;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SelectionSorterTest {
    private SortingServices factory;
    private Comparator<Integer> comparator;
    private Sorter<Integer> sorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.comparator = new CountingComparator<>(Integer::compareTo);
        this.sorter = this.factory.createSorter(SortKind.SELECTION, this.comparator);
    }

    @Test
    void constructorTest() {
        assertThat(this.sorter).isExactlyInstanceOf(SelectionSorter.class);
    }

    @Test
    void integerSortTest() {
        Queue<Integer> unsortedQueue = this.factory.createPreferredQueue(SortKind.SELECTION);
        unsortedQueue = fillUnsorted(5);
        var sortedQueue = new QueueImpl<Integer>();
        sortedQueue = (QueueImpl<Integer>) fillSorted(5);
        unsortedQueue = this.sorter.sort(unsortedQueue);
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

    Queue<Integer> fillUnsorted(int elementsCount) {
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }
}