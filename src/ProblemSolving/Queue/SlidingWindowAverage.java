package ProblemSolving.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowAverage {
    Queue<Integer> windowQueue;
    int count;
    int sizeOfWindow;

    public SlidingWindowAverage(int size) {
        windowQueue = new LinkedList<>();
        count = 0;
        sizeOfWindow = size;
    }

    public double next(int val) {
        windowQueue.add(val);
        count += 1;
        double average = 0;
        if (count > sizeOfWindow)
            windowQueue.remove();

        double totalValue = 0;
        for (Integer queue : windowQueue) {
            totalValue +=queue;
        }

        return totalValue/count;
    }
}
