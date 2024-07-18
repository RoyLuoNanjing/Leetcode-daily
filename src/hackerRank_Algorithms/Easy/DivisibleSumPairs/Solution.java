package hackerRank_Algorithms.Easy.DivisibleSumPairs;

import java.util.List;

public class Solution {
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(j) + ar.get(i)) % k == 0) {
                    count++;
                }
            }
        }

        return count;

    }
}
