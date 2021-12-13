package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.SortingServiceFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QueueImplTest {
    QueueImpl<Integer> selectionQueue;
    SortingServiceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.selectionQueue = (QueueImpl) this.factory.createPreferredQueue(SortKind.SELECTION);
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
        this.selectionQueue.put(1);
        assertThat(this.selectionQueue.getHeadNode()).isNotNull();
    }

    @Test
    void put() {
        int item = 1;
        this.selectionQueue.put(item);
        assertThat(this.selectionQueue.getHeadNode()).isNotNull();

    }

    @Test
    void get() {
        int putItem = 1;
        int expectedItem = 1;
        this.selectionQueue.put(putItem);
        assertThat(this.selectionQueue.get()).usingRecursiveComparison().isEqualTo(expectedItem);
    }

    @Test
    void getNull() {
        assertThat(this.selectionQueue.get()).usingRecursiveComparison().isNull();
    }

    @Test
    void isEmpty() {
        assertThat(this.selectionQueue.isEmpty()).isTrue();
        this.selectionQueue.put(1);
        assertThat(this.selectionQueue.isEmpty()).isFalse();
    }

    @Test
    void size() {
        this.selectionQueue.put(1);
        long expectedSize = 1;
        assertThat(this.selectionQueue.size()).isEqualTo(expectedSize);
    }

    @Test
    void peek() {
        this.selectionQueue.put(1);
        assertThat(this.selectionQueue.peek()).isEqualTo(1);
    }

    @Test
    void peekNull() {
        assertThat(this.selectionQueue.peek()).isNull();
    }

    @Test
    void iteratorHasNextTest() {
        this.selectionQueue.put(1);
        this.selectionQueue.put(2);
        assertThat(this.selectionQueue.iterator().hasNext()).isTrue();
        this.selectionQueue.get();
        this.selectionQueue.get();
        assertThat(this.selectionQueue.iterator().hasNext()).isFalse();
    }

    @Test
    void iteratorNextTest() {
        this.selectionQueue.put(1);
        this.selectionQueue.put(2);
        this.selectionQueue.put(3);
        var tempQueue = new QueueImpl<Integer>();
        for (Integer a : this.selectionQueue) {
            tempQueue.put(a);
        }
        assertThat(this.selectionQueue).usingRecursiveComparison().isEqualTo(tempQueue);
    }

   /* @Test
    void compareQueuesInsertionTest() {
        var first = this.factory.createPreferredQueue(SortKind.INSERTION);
        for (int i = 0; i < 5999; i++) {
            first.put(i);
            System.out.println(first.iterator().next());

        }
    }*/
}
