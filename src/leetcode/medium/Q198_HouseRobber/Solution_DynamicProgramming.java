package leetcode.medium.Q198_HouseRobber;

public class Solution_DynamicProgramming {

    public int rob(int[] nums) {
        int l = nums.length;

        //只有一个则直接回
        if (l == 1) return nums[0];


        //dp 容器
        int[] dp = new int[l];


        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //状态转移
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[dp.length - 1];

    }
    /**
     * Comment:
     * 标准的动态规划， 记住寻找状态转移条件，然后创建dp并初始化
     */
}
