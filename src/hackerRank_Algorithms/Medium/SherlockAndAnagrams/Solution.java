package hackerRank_Algorithms.Medium.SherlockAndAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String, Integer> substrCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String substr = s.substring(i, j);
                char[] charArray = substr.toCharArray();
                Arrays.sort(charArray);
                String sortedSubstr = new String(charArray);

                substrCount.put(sortedSubstr, substrCount.getOrDefault(sortedSubstr, 0) + 1);
            }
        }

        int anagramPairs = 0;
        for (int count : substrCount.values()
        ) {
            if (count > 1) {
                anagramPairs += (count * (count - 1)) / 2;
            }
        }

        return anagramPairs;
    }
}
