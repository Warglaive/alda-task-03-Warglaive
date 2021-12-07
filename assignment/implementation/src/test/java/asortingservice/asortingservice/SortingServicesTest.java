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

    private Comparator<T> comparator;

    @Test
    void createSelectionSorter() {
        this.comparator = (f1, f2) -> {
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
        var sorter = this.factory.createSorter(SortKind.SELECTION, this.comparator);
        assertThat(sorter).isExactlyInstanceOf(SelectionSorter.class);
    }
    @Test
    void createInsertionSorter() {
        this.comparator = (f1, f2) -> {
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
        var sorter = this.factory.createSorter(SortKind.INSERTION, this.comparator);
        assertThat(sorter).isExactlyInstanceOf(InsertionSorter.class);
    }
    @Test
    void supportedSorters() {
        var result = this.factory.supportedSorters();
        assertThat(result).isNotEmpty();
    }

    /**
     * TODO: Test defaults
     */
    @Test
    void createSorterDefaultTest() {
        assertThat(this.factory.createSorter("asd", this.comparator)).isNull();
    }

    @Test
    void createPreferredQueueDefaultTest() {
        assertThat(this.factory.createPreferredQueue("asd")).isNull();
    }

    @Test
    void extraSortersDefaultTest() {
        assertThat(this.factory.extraSorters()).isEmpty();
    }

    @Test
    void supportedSortersDefaultTest() {
        assertThat(this.factory.supportedSorters()).isNotEmpty();
    }
}
