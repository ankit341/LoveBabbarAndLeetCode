package problemsolving.Array;

public class MinimumElementsRequiredToAddToSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sumOfArrayElements = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfArrayElements += nums[i];
        }
        if (sumOfArrayElements == goal)
            return 0;

        long differenceOfGoalAndSum = Math.abs(goal - sumOfArrayElements);

        if (differenceOfGoalAndSum <= limit)
            return 1;

        long count = differenceOfGoalAndSum / limit;
        long remainder = differenceOfGoalAndSum % limit;

        if (remainder > 0)
            return (int)count + 1;

        return (int)count;
    }
}
