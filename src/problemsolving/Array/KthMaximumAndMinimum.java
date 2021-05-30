package problemsolving.Array;

import java.util.*;

public class KthMaximumAndMinimum {
    /*
    Finding the kth maximum and the minimum element of an array in O(n) complexity.
     */
    int kthMaximum;
    int kthMinimum;
    public static KthMaximumAndMinimum kthMaximumAndMinimumFunction(int[] array, int k) {
        KthMaximumAndMinimum kthMaxAndMin = new KthMaximumAndMinimum();

        Arrays.sort(array);
        kthMaxAndMin.kthMaximum = array[array.length - k];
        kthMaxAndMin.kthMinimum = array[k - 1];

        return  kthMaxAndMin;
    }

    public static KthMaximumAndMinimum kthMaximumAndMinimumFucntionWithHeap(int[] array, int k) {
        KthMaximumAndMinimum kthMaxAndMin = new KthMaximumAndMinimum();

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minheap.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] > minheap.peek()) {
                minheap.poll();
                minheap.add(array[i]);
            }
        }

        kthMaxAndMin.kthMaximum = minheap.peek();

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxheap.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] < maxheap.peek()) {
                maxheap.poll();
                maxheap.add(array[i]);
            }
        }

        kthMaxAndMin.kthMinimum = maxheap.peek();

        return kthMaxAndMin;
    }

    public static KthMaximumAndMinimum kthMaximumAndMinimumWithQuickSelect(int[] array, int k) {
        int left = 0;
        int lengthOfArray = array.length;
        int right = lengthOfArray - 1;
        KthMaximumAndMinimum kthMaxAndMin = new KthMaximumAndMinimum();

        while (left <= right) {
            Random random = new Random(0);

            int randomPivotIndex = random.nextInt(right - left + 1) + left;

            int correctPositionOfPivot = findCorrectPositionOfPivot(left, right, randomPivotIndex, array);

            if (correctPositionOfPivot == lengthOfArray - k) {
                kthMaxAndMin.kthMaximum = array[correctPositionOfPivot];
                return kthMaxAndMin;
            } else if (correctPositionOfPivot > lengthOfArray - k) {
                right = randomPivotIndex - 1;
            } else {
                left = randomPivotIndex + 1;
            }

        }
        return new KthMaximumAndMinimum();
    }

    public static int findCorrectPositionOfPivot(int left, int right, int randomPivotIndex, int[] array) {
        int first = right;
        int second = randomPivotIndex;
        int lesserElementIndex = left;
        int pivotValue = array[randomPivotIndex];

        swapNumbers(first, second, array);

        for (int i= left; i < right; i++) {
            if (array[i] < pivotValue){
                swapNumbers(i, lesserElementIndex, array);
                lesserElementIndex++;
            }
        }
        swapNumbers(right, lesserElementIndex, array);

        return lesserElementIndex;
    }

    public static void swapNumbers(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        kthMaximumAndMinimumFucntionWithHeap(new int[]{1,2,3,4}, 2);
    }
}
