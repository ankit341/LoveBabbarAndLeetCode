package problemsolving.Stacks;

import java.util.Stack;

public class RemoveOuterParenthesis {
    public static String removeOuterMostParenthesis(String string) {
        StringBuilder stringBuilder = new StringBuilder("");
        int length = string.length();

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == ')') {
                if (characterStack.size() > 0) {
                    if (characterStack.peek() == '(') {
                        characterStack.pop();
                        if (characterStack.size() >= 1) {
                            stringBuilder.append(string.charAt(i));
                        }
                    }
                }
            } else if (string.charAt(i) == '(') {
                characterStack.push(string.charAt(i));
                if (characterStack.size() > 1) {
                    stringBuilder.append(string.charAt(i));
                }
            }
        }
        int[] newArray = new int[string.length()];
        return stringBuilder.toString();
    }
}
