package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSorterTest {

    private SortingServices factory;
    private Comparator<Integer> intComparator;
    private Sorter<Integer> intSorter;


    private Comparator<String> stringComparator;
    private Sorter<String> stringSorter;


    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        //Integer
        this.intComparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        this.intSorter = this.factory.createSorter(SortKind.INSERTION, this.intComparator);
        //String
        this.stringComparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        this.stringSorter = this.factory.createSorter(SortKind.INSERTION, this.stringComparator);
    }

    @Test
    void integerSortTest() {
        Queue<Integer> unsortedQueue = this.factory.createPreferredQueue(SortKind.SELECTION);
        unsortedQueue = fillUnsorted(5);
        var sortedQueue = new QueueImpl<Integer>();
        sortedQueue = (QueueImpl<Integer>) fillSorted(5);
        unsortedQueue = this.intSorter.sort(unsortedQueue);
        for (int i = 0; i < unsortedQueue.size(); i++) {
            assertThat(unsortedQueue.get()).isEqualTo(sortedQueue.get());
        }
    }

    @Test
    void stringSortTest() {
        Queue<String> unsortedQueue = new QueueImpl<>();
        unsortedQueue.put("c");
        unsortedQueue.put("b");
        unsortedQueue.put("a");
        Queue<String> result = new QueueImpl<>();
        result = stringSorter.sort(unsortedQueue);
        for (int i = 0; i <= result.size(); i++) {
            System.out.println(result.get());
        }
    }

    @Test
    void nextNotNullSortTest() {
        Queue<Integer> unsortedQueue = fillSorted(5);
        QueueImpl<Integer> sortedQueue = (QueueImpl<Integer>) this.intSorter.sort(unsortedQueue);

        assertThat(sortedQueue).isSameAs(unsortedQueue);
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