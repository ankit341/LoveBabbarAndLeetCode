package problemsolving.Array;

/*
This should be solved with a notion of the minimum number of comparisons.
 */
public class MinimumAndMaximumOfArray {
    int minimum;
    int maximum;
    public static MinimumAndMaximumOfArray maximumAndMinimumOfArray(int[] array) {
        int max = array[0];
        int min = array[0];

        MinimumAndMaximumOfArray minAndMax = new MinimumAndMaximumOfArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }

        minAndMax.maximum = max;
        minAndMax.minimum = min;

        return minAndMax;
    }
}

