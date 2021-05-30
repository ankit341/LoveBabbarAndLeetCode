package ProblemSolving.Array;

import java.util.Arrays;

public class MinimizeTheHeights {
    public static int minimizeHeightsOfTowers(int[] arr, int n, int k) {
        int maximum = arr[0];
        int minimum = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > maximum)
                maximum = arr[i];

            if (arr[i] < minimum)
                minimum = arr[i];
        }

        return (maximum - k) - (minimum + k);
    }

    public static int minimizeHeightsOfTowersCorrectSolution(int[] arr, int n, int k) {
        Arrays.sort(arr);

        return  0;
    }
}
