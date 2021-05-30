package problemsolving.Array;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int i = 0;
        while (i <=rightPointer) {
            if (nums[i] == 0) {
                swapNumbers(i, leftPointer, nums);
                leftPointer++;
                i++;
            } else if (nums[i] == 2) {
                swapNumbers(i, rightPointer, nums);
                rightPointer--;
            } else
                i++;
        }
    }

    public static void swapNumbers(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,0,1};
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
