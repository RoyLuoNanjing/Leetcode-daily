package hackerRank_DataStructures.Medium.SparseArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();

        for (String s : stringList
        ) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (String s : queries
        ) {
            int times = map.getOrDefault(s,0);
            res.add(times);
        }

        return res;
    }
}
