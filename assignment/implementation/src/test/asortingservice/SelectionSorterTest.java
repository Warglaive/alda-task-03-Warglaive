package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.Sorter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSorterTest {
    private SortingServices factory;


    @BeforeEach
    void setUp() {
    this.factory= new SortingServices();
    }

    @Test
    void sort() {
        Queue<SelectionSorter> queue = factory.createPreferredQueue(sortKind);
        queue = fillRandom(queue, 100);
        Comparator<TestType> comp = new CountingComparator<>((a, b) -> a.compareTo(b));
        Sorter<String> sorter = factory.createSorter(sortKind, comp);
        Queue<String> sortedQueue = sorter.sort(queue);
        assertThat(sortedQueue).isSameAs(queue);
        assertThat(sortedQueue).isOrderedAccoridingTo(comp);
        // more tests.
    }

    void fillRandom(Queue queue, int elementsCount) {

    }
}