package leetcode.medium.Q3152_SpecialArrayII;

public class Solution_DynamicPrograming {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = i;
            }
        }

        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            result[i] = dp[to] <= from;
        }
        return result;

    }
}
