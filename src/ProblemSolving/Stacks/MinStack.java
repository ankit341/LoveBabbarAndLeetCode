package ProblemSolving.Stacks;

import java.util.Stack;

public class MinStack {
    Stack<Integer> originalStack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        originalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int sizeOfOriginalStack = originalStack.size();
            while (val > minStack.peek() && !minStack.isEmpty()) {
                originalStack.push(minStack.pop());
            }
            minStack.push(val);

            while (originalStack.size() > sizeOfOriginalStack) {
                minStack.push(originalStack.pop());
            }
        }

        originalStack.push(val);
    }

    public void pop() {
        int poppedElement = originalStack.pop();

        int sizeOfOriginalStack = originalStack.size();
        while (minStack.peek() != poppedElement) {
            originalStack.push(minStack.pop());
        }

        minStack.pop();

        while (originalStack.size() > sizeOfOriginalStack) {
            minStack.push(originalStack.pop());
        }

    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
