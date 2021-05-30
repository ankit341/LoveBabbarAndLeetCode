package problemsolving.Stacks;

import java.util.Stack;

public class StacksPOC {
    public static void main(String[] args) {
        Stack<Integer> stacksLearning = new Stack<>();
        stacksLearning.push(5);
        stacksLearning.push(5);
        stacksLearning.push(5);
        stacksLearning.push(5);
        Integer newChar = stacksLearning.pop();

        System.out.println(stacksLearning.peek());

        System.out.println(stacksLearning.size());
    }
}
