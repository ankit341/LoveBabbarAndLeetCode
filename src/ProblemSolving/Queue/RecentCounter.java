package ProblemSolving.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
    Deque<Integer> counterQueue;

    public RecentCounter() {
        counterQueue = new ArrayDeque<>();
    }

    public int ping(int t) {
        counterQueue.add(t);
        while (counterQueue.peek() - t > 3000) {
            counterQueue.remove();
        }

        return counterQueue.size();
    }
}
