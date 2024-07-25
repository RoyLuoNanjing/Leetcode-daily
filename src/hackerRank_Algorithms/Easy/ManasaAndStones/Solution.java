package hackerRank_Algorithms.Easy.ManasaAndStones;

import java.util.*;

public class Solution {
    public static List<Integer> stones(int n, int a, int b) {
        TreeSet<Integer> results = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int result = (n - 1 - i) * a + i * b;
            results.add(result);
        }

        return new ArrayList<>(results);
    }
}
