package ProblemSolving.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> intervalsList = new LinkedList<>();

        for (int[] interval : intervals) {
            if (intervalsList.isEmpty() || intervalsList.getLast()[1] < interval[0])
                intervalsList.add(interval);
            else {
                intervalsList.getLast()[1] = Math.max(intervalsList.getLast()[1], interval[1]);
            }
        }
        return intervalsList.toArray(new int[intervalsList.size()][]);
    }

    public static void main(String[] args) {
        int[][] arrayMerge = new int[][]{{1,3},{0,6},{8,10},{15,18}};
        Arrays.sort(arrayMerge, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < arrayMerge.length; i++) {
            for (int j = 0; j < arrayMerge[0].length; j++) {
                System.out.println(arrayMerge[i][j]);
            }
        }
    }
}
