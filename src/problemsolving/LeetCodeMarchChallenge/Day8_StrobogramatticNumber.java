package problemsolving.LeetCodeMarchChallenge;

public class Day8_StrobogramatticNumber {
    public static boolean isStrobogrammatic(String num) {
        int lengthOfString = num.length();
        String reverseNum = "";

        for (int i = 0; i < lengthOfString; i++) {
            if (num.charAt(i) == '2' || num.charAt(i) == '3' || num.charAt(i) == '4' || num.charAt(i) == '5' ||
                    num.charAt(i) == '7') {
                return false;
            }
            if (num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8')
                reverseNum = reverseNum + num.charAt(i);

            if (num.charAt(i) == '6')
                reverseNum = reverseNum + '9';

            if (num.charAt(i) == '9')
                reverseNum = reverseNum + '6';
        }

        int start = 0;
        int end = reverseNum.length() - 1;
        while(start < end) {
            if (num.charAt(start) != reverseNum.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
