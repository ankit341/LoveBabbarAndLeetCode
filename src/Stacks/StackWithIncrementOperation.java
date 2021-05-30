package Stacks;

import java.util.Stack;

public class StackWithIncrementOperation {
    Stack<Integer> originalStack;
    Stack<Integer> temporaryStack;
    int maxSize;
    int count;

    public StackWithIncrementOperation(int maxSize) {
        this.maxSize = maxSize;
        count = 0;
        originalStack = new Stack<>();
        temporaryStack = new Stack<>();
    }

    public void push(int x) {
        if (count < maxSize) {
            originalStack.push(x);
        }
    }

    public int pop() {
        if (!originalStack.isEmpty()) {
            return originalStack.pop();
        }
        return -1;
    }

    public void increment(int k, int val) {
        while (!originalStack.isEmpty()) {
            temporaryStack.push(originalStack.pop());
        }

        while (k > 0 && !temporaryStack.isEmpty()) {
            originalStack.push(temporaryStack.pop() + val);
            k--;
        }
    }
}
