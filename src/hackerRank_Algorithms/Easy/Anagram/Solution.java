package hackerRank_Algorithms.Easy.Anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int anagram(String s) {
        // Write your code here
        int length = s.length();
        if (length % 2 != 0) {
            return -1;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            char c = s.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int same = 0;

        for (char key : map1.keySet()
        ) {
            if (map2.containsKey(key)) {
                same += Math.min(map1.get(key), map2.get(key));
            }
        }

        return length/2 - same;
    }
}
