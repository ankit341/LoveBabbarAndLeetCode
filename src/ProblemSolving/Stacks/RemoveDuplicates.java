package ProblemSolving.Stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicateLetters(String s) {
        Set<Character> frequencySet = new HashSet<>();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0 ; i < s.length(); i++) {
            frequencySet.add(s.charAt(i));
        }

        for (Character character : frequencySet) {
            System.out.println(character);
        }

        return "";
    }

    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
        int i = Integer.valueOf("-11");
        System.out.println(i);
    }
}
