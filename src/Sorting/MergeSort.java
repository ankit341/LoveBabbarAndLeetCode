package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSortDividePhase(int[] nums, int start, int end) {
        //return condition
        if (end - start + 1 <= 1)
            return;
        int middle = start + (end - start) / 2;
        mergeSortDividePhase(nums, start, middle);
        mergeSortDividePhase(nums, middle + 1, end);
        mergeSortConquerPhase(nums, start, end, middle);
    }

    public static void mergeSortConquerPhase(int[] nums, int start, int end, int middle) {
        int leftPointer = start;
        int rightPointer = middle + 1;
        int[] tempArray = new int[end - start + 1];

        int t = 0;

        while (leftPointer <= middle && rightPointer <= end) {
            if (nums[leftPointer] < nums[rightPointer])
                tempArray[t++] = nums[leftPointer++];
            else
                tempArray[t++] = nums[rightPointer++];
        }

        while (leftPointer <= middle) {
            tempArray[t++] = nums[leftPointer++];
        }
        while (rightPointer <= end) {
            tempArray[t++] = nums[rightPointer++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = tempArray[i - start];
        }
    }

    public static void mergeSortArray(int[] array) {
        int start = 0;
        int end = array.length;

        mergeSortDividePhase(array, start, end - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,4,5,6,3,2,1};
        mergeSortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
