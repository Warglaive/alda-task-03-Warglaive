package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.Queue;
import sortingservice.SortKind;
import sortingservice.SortingServiceFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QueueImplTest<E> {
    QueueImpl<E> selectionQueue;
    SortingServiceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.selectionQueue = (QueueImpl<E>) this.factory.createPreferredQueue(SortKind.SELECTION);
    }

    @Test
    void constructorTest() {
        assertThat(this.selectionQueue).isExactlyInstanceOf(QueueImpl.class);

    }
}
