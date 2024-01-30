package leetcode.medium.Q279_PerfectSquares;

import java.util.Arrays;

public class Solution_DynamicProgramming {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //初始化dp数组
        Arrays.fill(dp, Integer.MAX_VALUE);

        //0的最少数量的完全平方数为0
        dp[0] = 0;

        //动态规划
        for (int i = 1; i < n + 1; i++) {
            //尝试所有可能的完全平方数
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * Comment:
     * 和322题换银币的思路一样的，标准的dp末班
     * 主要出在dp[i - j * j] + 1上面
     */
}
