package hackerRank_Algorithms.Easy.EqualizeTheArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int number = arr.get(i);

            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int max = 0;
        int count = 0;

        for (int values :
                map.values()) {
            max = Math.max(values, max);
            count += values;
        }

        return count - max;
    }
}
