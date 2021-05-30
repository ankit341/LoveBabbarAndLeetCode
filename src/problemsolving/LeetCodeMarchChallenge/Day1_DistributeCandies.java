package problemsolving.LeetCodeMarchChallenge;

import java.util.HashSet;
import java.util.Set;

public class Day1_DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> setOfTheCandies = new HashSet<>();

        for(int i = 0; i < candyType.length; i++) {
            setOfTheCandies.add(candyType[i]);
        }

        if (setOfTheCandies.size() > candyType.length/2)
            return candyType.length/2;

        return setOfTheCandies.size();
    }
}
