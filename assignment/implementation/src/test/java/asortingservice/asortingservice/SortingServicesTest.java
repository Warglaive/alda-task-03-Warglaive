package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.SortingServiceFactory;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortingServicesTest {

    SortingServiceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
    }

    @Test
    void constructorTest() {
        assertThat(this.factory).isExactlyInstanceOf(SortingServices.class);
    }

    @Test
    void createPreferredQueue() {
        var actual = this.factory.createPreferredQueue(SortKind.SELECTION);
        var expected = new QueueImpl<>();
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void createSorter() {
        var queue = this.factory.createPreferredQueue(SortKind.SELECTION);

        Comparator<Integer> comparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        var sorter = this.factory.createSorter(SortKind.SELECTION, comparator);
        assertThat(sorter).isExactlyInstanceOf(SelectionSorter.class);
    }

    @Test
    void supportedSorters() {
    }
}