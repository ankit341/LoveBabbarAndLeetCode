package ProblemSolving.Array;

public class RotateTheArrayByKCycle {
    public static void rotateArrayByBruteForce(int[] array, int k) {
        k%=array.length;
        for (int i = 0; i < k; i++) {
            int lastNumber = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = lastNumber;
        }
    }

    public static void rotateArrayByCyclicTendency(int[] array, int k) {
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            int newIndex = (k + i) % array.length;
            temp = array[newIndex];
            array[newIndex] = 4;
        }
    }

    public static void rotateArrayByReversal(int[] array, int k) {
        reverseArrayTillIndex(array, 0, array.length - 1);
        reverseArrayTillIndex(array, 0, k-1);
        reverseArrayTillIndex(array, k, array.length - 1);
    }

    public static void reverseArrayTillIndex(int[] array, int startIndex, int lastIndex) {
        int start = startIndex;
        int end = lastIndex;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
