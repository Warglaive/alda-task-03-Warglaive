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

    @Test
    void getHeadNodeNullTest() {
        assertThat(this.selectionQueue.getHeadNode()).isNull();
    }

    @Test
    void getHeadNodeNotNullTest() {
        this.selectionQueue.put((E) new Object());
        assertThat(this.selectionQueue.getHeadNode()).isNotNull();
    }

    @Test
    void put() {
        E item = (E) Integer.valueOf("1");
        this.selectionQueue.put(item);
        assertThat(this.selectionQueue.getHeadNode()).isNotNull();

    }

    @Test
    void get() {
        E putItem = (E) Integer.valueOf("1");
        E expectedItem = (E) Integer.valueOf("1");
        this.selectionQueue.put(putItem);
        assertThat(this.selectionQueue.get()).usingRecursiveComparison().isEqualTo(expectedItem);
    }

    @Test
    void isEmpty() {
        assertThat(this.selectionQueue.isEmpty()).isTrue();
        this.selectionQueue.put((E) Integer.valueOf("1"));
        assertThat(this.selectionQueue.isEmpty()).isFalse();
    }

    @Test
    void size() {
        this.selectionQueue.put((E) Integer.valueOf("1"));
        long expectedSize = 1;
        assertThat(this.selectionQueue.size()).isEqualTo(expectedSize);
    }

    @Test
    void peek() {
        this.selectionQueue.put((E) Integer.valueOf("1"));
        assertThat(this.selectionQueue.peek()).isEqualTo(1);
    }

    @Test
    void iterator() {
        
    }
}
