package Recursion;

public class PalindromeNumbers {
    public static boolean isPalindrome(int number) {
        int sum = 0;
        int reverseNumber = reverse(number, sum);
        return false;
    }

    public static int reverse(int number, int sum) {
        int quotient = number / 10;
        int remainder = number % 10;
        sum = sum * 10 + remainder;
        if (quotient > 0) {
            reverse(quotient, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(789, 0));
    }
}
