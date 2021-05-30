package ProblemSolving.Array;
/*
Input:
        N = 4, M = 5
        arr1[] = {1, 3, 5, 7}
        arr2[] = {0, 2, 6, 8, 9}
        Output: 0 1 2 3 5 6 7 8 9
        Explanation: Since you can't use any
        extra space, modify the given arrays
        to form
        arr1[] = {0, 1, 2, 3}
        arr2[] = {5, 6, 7, 8, 9}

 */
public class MergeWithoutExtraSpace {
    public static void mergeWithoutExtraSpace(int[] mArray, int[] nArray) {
        int mSize = mArray.length;
        int nSize = nArray.length;

        int mIndex = 0;
        int nIndex = 0;

        while (mIndex < mSize && nIndex < nSize) {
            if (mArray[mIndex] > nArray[nIndex]) {
                swapNumbersInArray(mIndex, nIndex, mArray, nArray);
                mIndex++;
            }
        }
    }

    public static void swapNumbersInArray(int firstIndex, int secondIndex, int[] array1, int[] array2) {
        int temp = array1[firstIndex];
        array1[firstIndex] = array2[firstIndex];
        array2[firstIndex] = temp;
    }
}
