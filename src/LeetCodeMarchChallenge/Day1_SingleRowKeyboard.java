package LeetCodeMarchChallenge;

import java.util.HashMap;
import java.util.Map;

public class Day1_SingleRowKeyboard {
    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> characterIndexMap = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++) {
            characterIndexMap.put(keyboard.charAt(i), i);
        }
        int totalTimeTaken = 0;
        int currentStep = 0;
        for (int i = 0; i < word.length(); i++) {
            totalTimeTaken += Math.abs(characterIndexMap.get(word.charAt(i)) - currentStep);
            currentStep = characterIndexMap.get(word.charAt(i));
        }

        return totalTimeTaken;
    }

    public static void main(String[] args) {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";

        System.out.println(calculateTime(keyboard, word));
    }
}
