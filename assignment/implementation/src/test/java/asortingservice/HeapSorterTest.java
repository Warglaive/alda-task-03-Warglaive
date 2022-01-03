package asortingservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSorterTest {
    private Comparator<Integer> integerComparator;

    @BeforeEach
    void setUp() {
        this.integerComparator = new CountingComparator<>(Integer::compareTo);
    }

    @Test
    void sort() {
        List<Integer> newList = new ArrayList<>();
        QueueImpl<Integer> newQueue = new QueueImpl<>();
        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            newQueue.put(randomNum);
        }

        HeapSorter<Integer> HeapSorter = new HeapSorter<>(integerComparator);
        QueueImpl<Integer> sorted2 = (QueueImpl<Integer>) HeapSorter.sort(newQueue);
        //sort using list sort
        newList.sort(integerComparator);

        newList.forEach((integer) -> assertEquals(integer, sorted2.get()));

        QueueImpl<Integer> queueImp = new QueueImpl<>();
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(200));
        }
        HeapSorter<Integer> heapSorter = new HeapSorter<>(integerComparator);

        //empty collections check
        assertEquals(queueImp, heapSorter.sort(queueImp));

        // put values in the Queue
        for (int a : list) {
            queueImp.put(a);
        }

        //sort the queue
        QueueImpl<Integer> sorted = (QueueImpl<Integer>) heapSorter.sort(queueImp);

        list.sort(integerComparator);

        //compare list and queue sorted
        list.forEach((integer) -> {
            assertEquals(integer, sorted.get());
        });
    }
}
