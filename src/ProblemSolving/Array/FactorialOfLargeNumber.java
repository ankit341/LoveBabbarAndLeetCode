package ProblemSolving.Array;

import java.math.BigInteger;

public class FactorialOfLargeNumber {
    public static BigInteger factorialBigNumber(int number) {
        BigInteger resultantFactorial = BigInteger.valueOf(1);

        for (int i = 2; i <= number; i++) {
            resultantFactorial = resultantFactorial.multiply(BigInteger.valueOf(i));
        }
        return resultantFactorial;
    }

    public static void factorialOfBigNumber(int number) {
        int[] factorialArray = new int[10000];
        factorialArray[0] = 1;
        int arraySize = 1;

        for (int i = 2; i <= number; i++) {
            arraySize = updateFactorial(i, factorialArray, arraySize);
        }

        for (int i = arraySize - 1; i >= 0; i--) {
            System.out.print(factorialArray[i]);
        }
    }

    public static int updateFactorial(int multiplier, int[] factorialArray, int arraySize) {
        int carry = 0;

        for (int i = 0; i < arraySize; i++) {
            int product = factorialArray[i] * multiplier + carry;
            factorialArray[i] = product % 10;
            carry = product / 10;
        }

        while (carry != 0) {
            factorialArray[arraySize] = carry % 10;
            carry = carry / 10;
            arraySize++;
        }

        return arraySize;
    }

    public static void main(String[] args) {
        int number = 20;
        System.out.println(factorialBigNumber(number));
        factorialOfBigNumber(number);
    }
}
