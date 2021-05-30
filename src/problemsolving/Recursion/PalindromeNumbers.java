package problemsolving.Recursion;

public class PalindromeNumbers {
    public static boolean isPalindrome(int number) {
        int sum = 0;
        int reverseNumber = reverse(number, sum);
        return false;
    }

    public static int reverse(int number, int sum) {
        if (number == 0) {
            return sum;
        }
        int quotient = number / 10;
        int remainder = number % 10;
        sum = sum * 10 + remainder;
        int result = reverse(quotient, sum);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234560000, 0)); // 789
    }
}
