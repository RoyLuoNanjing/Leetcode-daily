package hackerRank_Algorithms.Easy.IceCreamParlor;

import java.util.*;

public class Solution {
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            int target = m - current;
            if (map.containsKey(target)) {
                res.add(map.get(target));
                res.add(i + 1);
                break;
            } else {
                map.put(current, i + 1);
            }
        }

        Collections.sort(res);
        return res;
    }
}
