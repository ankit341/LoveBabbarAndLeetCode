package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionAndUnionOfArray {
    public static int[] intersectionAndUnion(int[] nums1, int[] nums2) {
        Set<Integer> firstArraySet = new HashSet<>();
        for (Integer n : nums1) firstArraySet.add(n);

        Set<Integer> secondArraySet = new HashSet<>();
        for (Integer n : nums2) secondArraySet.add(n);

        if (firstArraySet.size() > secondArraySet.size()) {
            return intersectionArray(secondArraySet, firstArraySet);
        }

        //For union
        //firstArraySet.addAll(secondArraySet);

        return intersectionArray(firstArraySet, secondArraySet);
    }

    public static int[] intersectionArray(Set<Integer> smallerSet, Set<Integer> biggerSet) {
        int[] intersectionArrayWithMaximumSize = new int[smallerSet.size()];
        int countOfIntersectionArray = 0;
        for (Integer n : smallerSet) {
            if (biggerSet.contains(n))
                intersectionArrayWithMaximumSize[countOfIntersectionArray++] = n;
        }

        return Arrays.copyOf(intersectionArrayWithMaximumSize, countOfIntersectionArray);
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {1,2,3,4,5,6,7,8,9};
        int[] array2 = new int[] {3,4,5,6};
        System.out.println(Arrays.toString(intersectionAndUnion(array1, array2)));
    }
}
