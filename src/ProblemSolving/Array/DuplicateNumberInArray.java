package ProblemSolving.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberInArray {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }

        return -1;
    }

    public int findDuplicateUsingSet(int[] nums) {
        Set<Integer> arrayElementsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (arrayElementsSet.contains(nums[i]))
                return nums[i];

            arrayElementsSet.add(nums[i]);
        }
        return -1;
    }

    public int findDuplicateUsingFloydAlgorithm(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return hare;
    }
}
