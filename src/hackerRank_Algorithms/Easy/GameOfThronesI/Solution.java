package hackerRank_Algorithms.Easy.GameOfThronesI;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String gameOfThrones(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int frequencyOfOddValues = 0;


        for (int value : map.values()
        ) {
            if (value % 2 != 0) {
                frequencyOfOddValues++;
            }
        }

        if (frequencyOfOddValues > 1) {
            return "NO";
        }

        return "YES";
    }
}
