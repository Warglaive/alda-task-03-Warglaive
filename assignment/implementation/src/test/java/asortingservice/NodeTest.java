package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sortingservice.SortingServiceFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NodeTest<E> {

    Node<E> node;
    Node<E> node2;
    String item;

    @BeforeEach
    void setUp() {
        this.item = "suicide";
        this.node = new Node<E>((E) this.item);
        this.node2 = new Node<E>(this.node);
    }

    @Test
    void constructorTest() {
        assertThat(this.node).isExactlyInstanceOf(Node.class);
    }

    @Test
    void constructorTest2() {
        assertThat(this.node2).isExactlyInstanceOf(Node.class);
    }

    @Test
    void getItem() {
    }

    @Test
    void getNext() {
    }

    @Test
    void getPrevious() {
    }

    @Test
    void setPrevious() {
    }

    @Test
    void setNext() {
    }
}