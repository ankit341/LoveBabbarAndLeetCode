package ProblemSolving.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class BackSpaceString {
    public static boolean backspaceCompare(String S, String T) {
        System.out.println(stringCalculator(S));
        System.out.println(stringCalculator(T));
        return stringCalculator(S).equals(stringCalculator(T));
    }

    public static String stringCalculator(String stringVariable) {
        Stack<Character> characterStack = new Stack<>();
        StringBuilder string = new StringBuilder("");
        int length = stringVariable.length();
        int i = 0;

        while (i < length) {
            if (stringVariable.charAt(i) == '#' && !characterStack.isEmpty()) {
                characterStack.pop();
            } else if (stringVariable.charAt(i) != '#'){
                characterStack.push(stringVariable.charAt(i));
            }

            i++;
        }

        while (!characterStack.isEmpty()) {
            string.append(characterStack.pop());
        }

        return string.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
        int[] newArray = new int[10];
        System.out.println(Arrays.toString(newArray));
    }
}
