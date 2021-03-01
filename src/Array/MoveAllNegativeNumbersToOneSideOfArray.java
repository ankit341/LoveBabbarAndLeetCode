package Array;

import java.util.Arrays;

public class MoveAllNegativeNumbersToOneSideOfArray {
    public static void moveNegativeElements(int[] array) {
        int readPointer = 0;
        int writePointer = array.length - 1;

        while (readPointer <= writePointer) {
            if (array[readPointer] < 0) {
                int temp = array[readPointer];
                array[readPointer] = array[writePointer];
                array[writePointer] = temp;
                writePointer--;
            } else {
                readPointer++;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{-11,-13,-15, 0, 0, -15};
        moveNegativeElements(array);
        System.out.println(Arrays.toString(array));
    }
}
