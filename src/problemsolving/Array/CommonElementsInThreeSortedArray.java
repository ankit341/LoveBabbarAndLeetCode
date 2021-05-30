package problemsolving.Array;

import java.util.ArrayList;

public class CommonElementsInThreeSortedArray {
    public static ArrayList<Integer> commonElementsInSortedArray(int[] nums1, int[] nums2, int[] nums3) {
        ArrayList<Integer> arrayListContainingAllElementsOfAnyOneArray = new ArrayList<Integer>();
        for (Integer nums : nums1) {
            arrayListContainingAllElementsOfAnyOneArray.add(nums);
        }
        ArrayList<Integer> arrayListContainingCommonOfFirstAndSecondArray = new ArrayList<>();
        for (Integer nums : nums2) {
            if (arrayListContainingAllElementsOfAnyOneArray.contains(nums))
                arrayListContainingCommonOfFirstAndSecondArray.add(nums);
        }
        ArrayList<Integer> arrayListContainingCommonElementsOfAll = new ArrayList<>();

        for (int nums : nums3) {
            if (arrayListContainingCommonOfFirstAndSecondArray.contains(nums))
                arrayListContainingCommonElementsOfAll.add(nums);
        }

        return arrayListContainingCommonElementsOfAll;
    }
}
