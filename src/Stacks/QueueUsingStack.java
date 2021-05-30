package Stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> originalStack;
    Stack<Integer> tempStack;
    int sizeOfStack;

    /** Initialize your data structure here. */
    public QueueUsingStack() {
        originalStack = new Stack<>();
        tempStack = new Stack<>();
        sizeOfStack = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.originalStack.push(x);
        this.sizeOfStack++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (sizeOfStack > 0) {
            while (!originalStack.isEmpty()) {
                tempStack.push(originalStack.pop());
            }
            int poppedValue = tempStack.pop();

            while (!tempStack.isEmpty()) {
                originalStack.push(tempStack.pop());
            }
            sizeOfStack--;
            return poppedValue;
        } else {
            throw new EmptyStackException();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (sizeOfStack > 0) {
            while (!originalStack.isEmpty()) {
                tempStack.push(originalStack.pop());
            }
            int peekedValue = tempStack.peek();
            while (!tempStack.isEmpty()) {
                originalStack.push(tempStack.pop());
            }
            return peekedValue;
        } else {
            throw new EmptyStackException();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return sizeOfStack == 0;
    }
}
