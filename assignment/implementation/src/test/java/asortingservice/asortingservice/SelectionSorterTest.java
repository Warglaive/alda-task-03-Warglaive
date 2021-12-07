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

class SelectionSorterTest {
    private SortingServices factory;
    private Comparator<Integer> comparator;
    private Sorter<Integer> sorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.comparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        this.sorter = this.factory.createSorter(SortKind.SELECTION, this.comparator);
    }

    @Test
    void constructorTest() {
        assertThat(this.sorter).isExactlyInstanceOf(SelectionSorter.class);
    }

    @Test
    void integerSortTest() {
        //TODO: Fix Node's references
        Queue<Integer> unsortedQueue = this.factory.createPreferredQueue(SortKind.SELECTION);
        //hardcoded elementsCount value for test purposes
        unsortedQueue = fillUnsorted(5);
        var sortedQueue = new QueueImpl<Integer>();
        sortedQueue = (QueueImpl<Integer>) fillSorted(5);

        //TODO: FIX
        assertThat(sortedQueue).usingRecursiveComparison().isEqualTo(unsortedQueue);
    }

    Queue<Integer> fillSorted(int elementsCount) {
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = 1; i <= elementsCount; i++) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }

    Queue<Integer> fillUnsorted(int elementsCount) {
        //make unsorted queue
        Queue<Integer> unsortedQueue = new QueueImpl<>();
        for (int i = elementsCount; i > 0; i--) {
            unsortedQueue.put(i);
        }
        return unsortedQueue;
    }

    @Test
    void compareToTest() {
        SelectionSorter<Integer> sorter = new SelectionSorter<>(this.comparator);
        ThrowableAssert.ThrowingCallable code = () -> {
            sorter.compareTo(1);
        };
        assertThatThrownBy(code).isExactlyInstanceOf(ClassCastException.class);
    }
}