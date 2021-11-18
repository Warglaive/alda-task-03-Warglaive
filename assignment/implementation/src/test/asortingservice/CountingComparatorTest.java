/*
package asortingservice;

import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;
import sortingservice.SortingServiceFactory;

import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountingComparatorTest {
    private SortingServiceFactory factory;

    @Test
    void test() {

        Queue<SortKind> queue = factory.createPreferredQueue(SortKind.INSERTION);
        queue = fillRandom(queue, 100);
        Comparator<TestType> comp = new CountingComparator<>((a, b) -> a.compareTo(b));
        Sorter<String> sorter = factory.createSorter(sortKind, comp);
        Queue<String> sortedQueue = sorter.sort(queue);
        assertThat(sortedQueue).isSameAs(queue);
        assertThat(sortedQueue).isOrderedAccoridingTo(comp);
    }

    */
/**
     * @param queue
     * @param n
     * @return filled queue
     *//*

    Queue<SortKind> fillRandom(Queue<SortKind> queue, int n) {
        for (int i = 0; i < n; i++) {
                queue.put();
        }
    }
}*/
