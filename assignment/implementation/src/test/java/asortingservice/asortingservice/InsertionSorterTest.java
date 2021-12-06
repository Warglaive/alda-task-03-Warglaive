package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

public class InsertionSorterTest {

    private SortingServices factory;
    private Comparator<Integer> comparator;
    private Sorter<Integer> sorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.comparator = new CountingComparator<>((a, b) -> a.compareTo(b));
        this.sorter = this.factory.createSorter(SortKind.INSERTION, this.comparator);
    }

    @Test
    void sort() {
    }
}
