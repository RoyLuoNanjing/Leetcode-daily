package hackerRank.Easy.MigratoryBirds;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxKey = 0;
        int maxValue = 0;

        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            } else if (value == maxValue) {
                if (key < maxKey) {
                    maxKey = key;
                }
            }
        }
        return maxKey;

    }
}
