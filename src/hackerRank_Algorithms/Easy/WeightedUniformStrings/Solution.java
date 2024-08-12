package hackerRank_Algorithms.Easy.WeightedUniformStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        List<String> res = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        int total = s.charAt(0) - 'a' + 1;
        set.add(total);
        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i) - 'a' + 1;
            if (s.charAt(i) == s.charAt(i - 1)) {
                set.add(current);
                total += current;
                set.add(total);
            } else {
                set.add(current);
                total = current;
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            if (set.contains(queries.get(i))) {
                res.add("Yes");
            } else {
                res.add("No");
            }
        }
        return res;
    }
}
