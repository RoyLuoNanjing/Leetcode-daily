package hackerRank_Algorithms.Easy.FlatlandSpaceStations;

public class Solution {
    static int flatlandSpaceStations(int n, int[] c) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < c.length; j++) {
                min = Math.min(min, Math.abs(c[j] - i));
            }
            max = Math.max(max, min);
        }

        return max;
    }
}
