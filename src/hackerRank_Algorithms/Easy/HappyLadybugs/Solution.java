package hackerRank_Algorithms.Easy.HappyLadybugs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String happyLadybugs(String b) {
        // Write your code here

        int l = b.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
        }

        //1. all underscore
        if (map.size() == 1 && map.get('_') != null) {
            return "YES";
        }

        //2. if any of them only contains one
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (key != '_' && value == 1) {
                return "NO";
            }
        }


        //3. if no underscore
        if (map.get('_') == null) {
            if (b.charAt(0) != b.charAt(1) || b.charAt(l - 1) != b.charAt(l - 2)) {
                return "NO";
            }


            for (int i = 1; i < l - 1; i++) {
                if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
                    return "NO";
                }
            }
            return "YES";
        }

        return "YES";
    }
}
