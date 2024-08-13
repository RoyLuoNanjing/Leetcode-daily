package hackerRank_Algorithms.Easy.MakingAnagrams;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();


        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int same = 0;

        for (char c : map1.keySet()
        ) {
            if (map2.containsKey(c)) {
                same += Math.min(map1.get(c), map2.get(c));
            }
        }

        return s1.length() + s2.length() - 2 * same;
    }
}
