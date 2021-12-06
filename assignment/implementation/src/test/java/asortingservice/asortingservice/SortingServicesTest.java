package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.SortingServiceFactory;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SortingServicesTest<T> {

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
        Comparator<T> comparator = (f1, f2) -> {
            Comparable compA = null;
            Comparable compB = null;

            // getting fields from object f1,f2
            compA = (Comparable) f1;
            compB = (Comparable) f2;

            // handling null comparators
            if (compA == null)
                return -1;
            else if (compB == null)
                return 1;

            return compA.compareTo(compB);
        };
        var sorter = this.factory.createSorter(SortKind.SELECTION, comparator);
        assertThat(sorter).isExactlyInstanceOf(SelectionSorter.class);
    }

    @Test
    void supportedSorters() {
        var sortingServices= new SortingServices();
        var result = sortingServices.supportedSorters();
        assertThat(result).isNotEmpty();
    }
}
