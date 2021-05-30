package problemsolving.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowAverage2 {
    Deque<Integer> doubleQueue;
    int count;
    int sizeOfWindow;
    double totalValue;

    public SlidingWindowAverage2(int size) {
        doubleQueue = new ArrayDeque<>(size);
        count = 0;
        sizeOfWindow = size;
        totalValue = 0;
    }
    public double next(int val) {
        totalValue += val;
        count += 1;

        int tail = count > sizeOfWindow ? doubleQueue.poll() : 0;
        count--;

        totalValue -= tail;

        return totalValue / doubleQueue.size();
    }
}
