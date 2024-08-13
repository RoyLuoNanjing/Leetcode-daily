package hackerRank_Algorithms.Easy.Gemstones;

import java.util.*;

public class Solution {
    public static int gemstones(List<String> arr) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                set.add(c);

            }

            for (char c :
                    set) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int count = 0;

        for (int number : map.values()
        ) {
            if (number == arr.size()) {
                count++;
            }
        }

        return count;
    }
}
