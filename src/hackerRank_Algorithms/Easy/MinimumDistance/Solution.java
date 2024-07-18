package hackerRank_Algorithms.Easy.MinimumDistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        boolean targetFound = false;
        int minDistance = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if (map.get(a.get(i)) != null) {
                int lastDistance = map.get(a.get(i));
                minDistance = Math.min(i - lastDistance, minDistance);
                targetFound = true;

            } else {
                map.put(a.get(i), i);
            }
        }

        if (!targetFound) return -1;

        return minDistance;
    }
}
