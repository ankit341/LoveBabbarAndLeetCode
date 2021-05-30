package ProblemSolving.LeetCodeMarchChallenge;

public class Day3_MissingNumber {
    public static int missingNumber(int[] nums) {
        int length = nums.length;
        int idealSum = (length * (length + 1)) / 2;
        int originalSum = 0;

        for (int n : nums) {
            originalSum += n;
        }

        return idealSum - originalSum;
    }
}
