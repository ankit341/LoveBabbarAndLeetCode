package ProblemSolving.Queue;

import java.util.*;

public class QueuePOC {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(11);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);

//        System.out.println(Arrays.toString(queue.stream().mapToInt(Integer :: intValue).toArray()));
//
//        queue.remove();
//
//        System.out.println(Arrays.toString(queue.stream().mapToInt(Integer :: intValue).toArray()));


        Deque<Integer> deque = new ArrayDeque<>(3);

        deque.add(4);
        deque.add(4);
        deque.add(4);
        deque.add(4);

        System.out.println(Arrays.toString(deque.stream().mapToInt(Integer -> Integer.intValue()).toArray()));
    }
}
