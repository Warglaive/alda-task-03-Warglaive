package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SelectionSorterTest {
    private SortingServices factory;


    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
    }

    @Test
    void sort() {
        Queue<Sorter> queue = factory.createPreferredQueue(SortKind.SELECTION);
        queue = fillRandom(queue, 100);
        Comparator<Sorter> comp = new CountingComparator<>( ( a, b ) -> a.compareTo( b ) );
        Sorter<Sorter> sorter = factory.createSorter(SortKind.SELECTION, comp);
        Queue<Sorter> sortedQueue = sorter.sort(queue);
        assertThat(sortedQueue).isSameAs(queue);
        assertThat(sortedQueue).isOrderedAccoridingTo(comp);
        // more tests.
    }

    Queue<Sorter> fillRandom(Queue queue, int elementsCount) {

    }
}