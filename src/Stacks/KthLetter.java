package Stacks;

public class KthLetter {
        public String decodeAtIndex(String S, int K) {
            if (K == 1)
                return S.substring(0,1);

            StringBuilder stringBuilder = new StringBuilder("");
            StringBuilder tempString = new StringBuilder("");
            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i))) {
                    int j = i + 1;
                    int digit = S.charAt(i) - '0';

                    while (digit > 0) {
                        stringBuilder.append(tempString);
                        if (stringBuilder.length() > K)
                            break;
                        digit--;
                    }

                    if (stringBuilder.length() > K)
                        break;

                    tempString = new StringBuilder(stringBuilder);
                    stringBuilder = new StringBuilder("");
                } else {
                    tempString.append(S.charAt(i));
                }
            }

            if (stringBuilder.length() > 0)
                return stringBuilder.toString().substring(K-1, K);

            return tempString.toString().substring(K-1, K);
        }

}
