package asortingservice;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class HeapSorterTest {

    @Test
    void sort() {
        Comparator<Integer> comparator = (Integer a, Integer b) -> {
            if (a > b) {
                return 1;
            }
            if (Objects.equals(a,b)) {
                return 0;
            }
            return -1;
        };

        List<Integer> newList = new ArrayList<>();
        QueueImpl<Integer> newQueue = new QueueImpl<>();
        newList.add(4);
        newList.add(10);
        newList.add(3);
        newList.add(5);
        newList.add(1);
        for (int a : newList) {
            newQueue.put(a);
        }

        HeapSorter<Integer> HeapSorter = new HeapSorter<>(comparator);
        QueueImpl<Integer> sorted2 = (QueueImpl<Integer>) HeapSorter.sort(newQueue);
        newList.sort(comparator);

        newList.forEach((integer) -> assertEquals(integer, sorted2.get()));

        QueueImpl<Integer> queueImp = new QueueImpl<>();
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(200));
        }
        HeapSorter<Integer> heapSorter = new HeapSorter<>(comparator);

        assertEquals(queueImp, heapSorter.sort(queueImp));

        // put values in the Queue
        for (int a : list) {
            queueImp.put(a);
        }


        QueueImpl<Integer> sorted = (QueueImpl<Integer>) heapSorter.sort(queueImp);
        list.sort(comparator);

        list.forEach((integer) -> {
            assertEquals(integer, sorted.get());
        });
    }
}
