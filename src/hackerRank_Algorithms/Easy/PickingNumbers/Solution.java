package hackerRank_Algorithms.Easy.PickingNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> reference = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < a.size(); i++) {
            if (map.get(a.get(i)) == null) {
                reference.add(a.get(i));
                map.put(a.get(i), 1);
            } else {
                map.put(a.get(i), map.get(a.get(i)) + 1);
            }
        }

        for (int i = 0; i < reference.size(); i++) {
            int current = reference.get(i);
            int currentCount = map.get(current);
            max = Math.max(max, currentCount); // 单独当前数字的情况

            if (i < reference.size() - 1 && reference.get(i + 1) == current + 1) {
                int nextCount = map.get(reference.get(i + 1));
                max = Math.max(max, currentCount + nextCount);
            }
        }

        return max;
    }

}
