package Array;

import java.util.Arrays;

public class CountInversions {
    public static int countInversions(int[] nums) {
        int length = nums.length;
        int totalInversions = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <length; j++) {
                if (nums[i] > nums[j])
                    totalInversions++;
            }
        }
        return totalInversions;
    }

    public static int countInversionUsingMergeSort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        return mergeSortDividePhase(nums, start, end);
    }

    public static int mergeSortDividePhase(int[] nums, int start, int end) {
        //return condition
        int countOfInversion = 0;
        if (start < end) {
            int middle = start + (end - start) / 2;
            countOfInversion += mergeSortDividePhase(nums, start, middle);
            countOfInversion += mergeSortDividePhase(nums, middle + 1, end);
            countOfInversion += mergeSortConquerPhase(nums, start, end, middle);
        }

        return countOfInversion;
    }

    public static int mergeSortConquerPhase(int[] nums, int start, int end, int middle) {
        int[] left = Arrays.copyOfRange(nums, start, middle + 1);

        int[] right = Arrays.copyOfRange(nums, middle + 1, end + 1);

        int leftPointer = 0;
        int rightPointer = 0;

        int t = start;
        int swap = 0;
        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] <= right[rightPointer])
                nums[t++] = left[leftPointer++];
            else {
                nums[t++] = right[rightPointer++];
                swap += middle - start - leftPointer + 1;
            }
        }

        while (leftPointer < left.length) {
            nums[t++] = left[leftPointer++];
        }
        while (rightPointer < right.length) {
            nums[t++] = right[rightPointer++];
        }

        return swap;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,4,5,6,3,2,1};
        countInversionUsingMergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
