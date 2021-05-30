package problemsolving.Stacks;

import java.util.Stack;

public class ReverseStringBuilderBetweenParentheses {
    public static String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        return "";
    }


    public static void main(String[] args) {
        System.out.println(reverseParentheses("ta()usw((((a))))"));
    }
}
