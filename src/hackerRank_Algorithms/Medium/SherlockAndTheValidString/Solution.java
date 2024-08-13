package hackerRank_Algorithms.Medium.SherlockAndTheValidString;

import java.util.*;

public class Solution {
    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int value : map.values()
        ) {

            map2.put(value, map2.getOrDefault(value, 0) + 1);
            if (map2.size() > 2) return "NO";
        }


        List<Integer> list = new ArrayList<>();
        for (int value : map2.keySet()
        ) {
            list.add(value);
        }

        if (map2.size() == 1 || (map2.keySet().contains(1) && map2.get(1) == 1)) {
            return "YES";
        }

        int large = Math.max(list.get(0), list.get(1));
        int small = Math.min(list.get(0), list.get(1));

        if (map2.get(large) == 1 && large - small == 1) {
            return "YES";
        }

        return "NO";
    }
}
