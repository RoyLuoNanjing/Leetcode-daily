package hackerRank.Easy.ServiceLane;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> serviceLane(int n, List<List<Integer>> cases, List<Integer> width) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> c : cases) {
            int start = c.get(0);
            int end = c.get(1);

            int minWidth = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                if (width.get(i) < minWidth) {
                    minWidth = width.get(i);
                }
            }
            result.add(minWidth);
        }

        return result;
    }
}
