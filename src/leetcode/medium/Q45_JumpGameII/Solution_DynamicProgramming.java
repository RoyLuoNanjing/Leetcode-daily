package leetcode.medium.Q45_JumpGameII;

import java.util.Arrays;

public class Solution_DynamicProgramming {
    public int jump(int[] nums) {
        int n = nums.length;
        //创建一个数组用于记录到达每个点的最小跳跃次数
        int[] dp = new int[n];
        //将每个点全部初始化为最大的值
        Arrays.fill(dp,Integer.MAX_VALUE);
        //第一个点不需要跳跃
        dp[0] = 0;

        //遍历数组元素
        for (int i = 1; i < n; i++) {
            //在位置j(j<i)的条件下，找到能到达i的最小跳跃次数
            for (int j = 0; j < i; j++) {
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[i],dp[j] + 1); //保留最小的跳跃次数
                }
            }

        }
        return dp[n-1];
    }
    /**
     * COMMENTS:
     * 标准dp，主要还是要考虑每次到一个点，要遍历前面所有的可能，找到最佳的值
     */
}



/*
You are given a 0-indexed array of integers nums of length n.
You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */