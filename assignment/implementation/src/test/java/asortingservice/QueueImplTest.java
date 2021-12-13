package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sortingservice.SortKind;
import sortingservice.SortingServiceFactory;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Iterator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueImplTest<E> {
    QueueImpl<E> queue;
    SortingServiceFactory factory;
    Node<E> node;
    Node<E> node2;
    String item;

    @BeforeEach
    void setUp() {
        this.factory = new SortingServices();
        this.queue = (QueueImpl<E>) this.factory.createPreferredQueue(SortKind.SELECTION);
        this.item = "suicide";
        this.node = new Node<E>((E) this.item);
        this.node2 = new Node<E>(this.node);
    }

    @Test
    void constructorTest() {
        assertThat(this.queue).isExactlyInstanceOf(QueueImpl.class);
    }

    @Test
    void getHeadNullTest() {
        assertThat(this.queue.getHead()).isNull();
    }

    @Test
    void getHeadNotNullTest() {
        this.queue.put((E) new Object());
        assertThat(this.queue.getHead()).isNotNull();
    }

    @Test
    void put() {
        E item = (E) Integer.valueOf("1");
        this.queue.put(item);
        assertThat(this.queue.getHead()).isNotNull();

    }

    @Test
    void get() {
        E putItem = (E) Integer.valueOf("1");
        E expectedItem = (E) Integer.valueOf("1");
        this.queue.put(putItem);
        assertThat(this.queue.get()).usingRecursiveComparison().isEqualTo(expectedItem);
    }

    @Test
    void getNull() {
        assertThat(this.queue.get()).usingRecursiveComparison().isNull();
    }

    @Test
    void isEmpty() {
        assertThat(this.queue.isEmpty()).isTrue();
        this.queue.put((E) Integer.valueOf("1"));
        assertThat(this.queue.isEmpty()).isFalse();
    }

    @Test
    void size() {
        this.queue.put((E) Integer.valueOf("1"));
        long expectedSize = 1;
        assertThat(this.queue.size()).isEqualTo(expectedSize);
    }

    Integer i = 1;
    Integer ii = 2;

    @Test
    void iterator() {
        QueueImpl<Integer> queueImpl = new QueueImpl<>();
        Iterator<Integer> iterator = queueImpl.iterator();
        try{
            iterator.next();

        }catch (NullPointerException e){
            assertEquals("There is no next in the queue!",e.getMessage());
        }
        queueImpl.put(7);
        queueImpl.put(5);
        queueImpl.put(3);
        queueImpl.put(6);
        queueImpl.put(4);


        while (iterator.hasNext()){
            iterator.next();
        }
        assertEquals(false,iterator.hasNext());
        try{
            iterator.next();

        }catch (NullPointerException e){
            assertEquals("There is no next in the queue!",e.getMessage());
        }
        Node a = queueImpl.getTail();
        assertNotNull(a.getItem());
    }


}
