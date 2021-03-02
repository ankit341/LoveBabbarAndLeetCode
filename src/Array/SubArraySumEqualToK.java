package Array;

import java.util.HashMap;

public class SubArraySumEqualToK {
    //Wrong method
    public static boolean subarraySum(int[] nums, int k) {
        int sumOfNumbers = nums[0];
        if (sumOfNumbers == k)
            return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == k)
                return true;

            int differenceOfCurrentSumFromK = Math.abs(sumOfNumbers + nums[i] - k);
            int differenceOfCurrentNumberFromK = Math.abs(nums[i] - k);
            sumOfNumbers = differenceOfCurrentSumFromK > differenceOfCurrentNumberFromK ? nums[i] : nums[i] + sumOfNumbers;

            if (sumOfNumbers == k)
                return true;
        }
        return false;
    }

    public static boolean subArraySumBruteForce(int[] nums, int k) {
        int countOfSubArrays = 0;
        int start = 0;
        for (int i = start; i < nums.length; i++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += nums[j];
                }
                if (sum == k)
                    countOfSubArrays++;
            }
        }
        return countOfSubArrays > 0;
    }

    public static boolean subArraysSumBruteForceOptimized(int[] nums, int k) {
        int countOfSubArrays = 0;
        int start = 0;

        for (int i = start; i < nums.length; i++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
            }
            if (sum == k)
                countOfSubArrays++;
        }
        return countOfSubArrays > 0;
    }

    public static boolean subArraysSumHashMapImplementation(int[] nums, int k) {
        int countOfSubArrays = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumAndSumFrequency = new HashMap<>();
        sumAndSumFrequency.put(0,1);
        for (int n : nums) {
            sum += n;
            if (sumAndSumFrequency.containsKey(sum - k))
                countOfSubArrays++;
            sumAndSumFrequency.put(sum, sumAndSumFrequency.getOrDefault(sum, 0) + 1);
        }
        return countOfSubArrays > 0;
    }

    public static void main(String[] args) {
        int[] arrayArgument = new int[] {4,2,6,1,-3};
        System.out.println(subarraySum(arrayArgument, 0));
    }
}
