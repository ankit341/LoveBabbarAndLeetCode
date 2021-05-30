package ProblemSolving.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class QueueImplementation {
    private List<Integer> queue;
    int index;

    public QueueImplementation(){
        queue = new ArrayList<Integer>();
        index = 0;
    }

    public boolean enqueue(int value) {
        queue.add(value);
        return true;
    }

    public boolean dequeue() {
        if (isQueueEmpty())
            return false;
        index++;
        return true;
    }

    public boolean isQueueEmpty() {
        return index >=queue.size();
    }

    public int getFirstElementInQueue() {
        return queue.get(index);
    }
}
