package problemsolving.Array;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    public static int pairsWithGivenSumInArray(int[] nums, int sum) {
        int length = nums.length;
        int numberOfPairs = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == sum - nums[j])
                    numberOfPairs++;
            }
        }
        return numberOfPairs;
    }

    public static int pairsWithGivenSumInArrayHashMap(int[] nums, int sum) {
        int length = nums.length;
        HashMap<Integer, Integer> mapWithArrayElementsAndFrequency = new HashMap<>();
        for (int num : nums) {
            if (!mapWithArrayElementsAndFrequency.containsKey(num)) {
                mapWithArrayElementsAndFrequency.put(num, 0);
            }
            mapWithArrayElementsAndFrequency.put(num, mapWithArrayElementsAndFrequency.get(num + 1));
        }

        int numberOfPairs = 0;

        for (int num : nums) {
            if (mapWithArrayElementsAndFrequency.containsKey(sum - num))
                numberOfPairs += mapWithArrayElementsAndFrequency.get(sum - num);

            if (sum - num == num)
                numberOfPairs--;
        }

        return numberOfPairs/2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 7, 1};
        System.out.println(pairsWithGivenSumInArray(array, 6));
    }
}
