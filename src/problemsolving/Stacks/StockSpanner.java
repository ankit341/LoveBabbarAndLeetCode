package problemsolving.Stacks;

import java.util.Stack;

public class StockSpanner {
    Stack<Integer> stockStack;
    Stack<Integer> tempStack;
    int count;

    public StockSpanner() {
        stockStack = new Stack<>();
        tempStack = new Stack<>();
        count = 1;
    }

    public int next(int price) {
        if (stockStack.isEmpty()) {
            stockStack.push(price);
            return 1;
        } else if (stockStack.peek() > price) {
            stockStack.push(price);
            return 1;
        } else {
            while (!stockStack.isEmpty() && stockStack.peek() < price) {
                count++;
                tempStack.push(stockStack.pop());
            }

            while (!tempStack.isEmpty()) {
                stockStack.push(tempStack.pop());
            }
        }

        return count;
    }
}
