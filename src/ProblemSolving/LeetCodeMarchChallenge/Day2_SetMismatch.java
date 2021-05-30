package ProblemSolving.LeetCodeMarchChallenge;

import java.util.HashMap;

public class Day2_SetMismatch {
    public static int[] findErrorNumbers(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j])
                    count++;
            }
            if (count == 2)
                duplicate = i;
            else if (count == 0)
                missing = i;
        }
        return new int[] {duplicate, missing};
    }

    public static int[] findErrorNumbersHashMap(int[] nums) {
        int duplicate = -1;
        int missing = -1;
        HashMap<Integer, Integer> numberAndFrequency = new HashMap<>();

        for (int n : nums) {
            numberAndFrequency.put(n, numberAndFrequency.getOrDefault(n, 0) + 1);
            if (numberAndFrequency.get(n) == 2)
                duplicate = n;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numberAndFrequency.containsKey(i)) {
                missing = i;
            }
        }

        return new int[] {duplicate, missing};
    }

    public static int[] findErrorNumbersWIthConstantSpace(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0)
                duplicate = n;
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }

        return new int[] {duplicate, missing};
    }
}
