package ProblemSolving.Array;

public class ReverseTheArray {
    public static int[] reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }

        return array;
    }

    public static int[] reverseArrayRecursion(int[] array) {
        int start = 0;
        int end = array.length - 1;

        reverseRecursion(array, start, end);
        return array;
    }

    public static void reverseRecursion(int[] array, int start, int end) {
        if (start >= end)
            return;

        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;

        reverseRecursion(array, start++, end--);
    }
}
