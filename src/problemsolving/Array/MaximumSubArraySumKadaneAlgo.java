package problemsolving.Array;

public class MaximumSubArraySumKadaneAlgo {
    public static int maximumSubArrayUsingGreedy(int[] nums) {
        int currentMax = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(currentMax, maxSum);
        }

        return maxSum;
    }

    public static int maximumSubArrayUsingDynamic(int[] nums) {
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if(nums[i-1] > 0) nums[i] += nums[i-1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static int maximumSubArrayCubicTime(int[] nums) {
        int maximumValue = Integer.MIN_VALUE;
        int n = nums.length;

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int windowSum = 0;

                for (int k = left; k < right; k++) {
                    windowSum  += nums[k];
                }

                maximumValue = Math.max(windowSum, maximumValue);
            }
        }

        return maximumValue;
    }

    public static int maximumSubArrayQuadraticTime(int[] nums) {
        int maximumValue = Integer.MIN_VALUE;
        int n = nums.length;

        for (int left = 0; left < n; left++) {
            int windowSum = 0;
            for (int right = left; right < n; right++) {
                windowSum += nums[right];
            }

            maximumValue = Math.max(windowSum, maximumValue);
        }

        return maximumValue;
    }
}
