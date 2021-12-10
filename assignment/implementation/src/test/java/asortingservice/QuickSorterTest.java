import asortingservice.CountingComparator;
import asortingservice.SortingServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.Sorter;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSorterTest {
    private SortingServices factory;
    private Comparator<Integer> integerComparator;
    private Sorter<Integer> integerSorter;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        //Integer
        this.integerComparator = new CountingComparator<>(Integer::compareTo);
        this.integerSorter = this.factory.createSorter(SortKind.INSERTION, this.integerComparator);
    }

    @Test
    void sort() {
    }

    @Test
    void partition() {
    }
}