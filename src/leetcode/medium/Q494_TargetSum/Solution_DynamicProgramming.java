package leetcode.medium.Q494_TargetSum;

public class Solution_DynamicProgramming {
    public int findTargetSumWays(int[] nums, int target) {
        //计算整个数组的元素总和
        int sum = 0;
        for (int num : nums) sum += num;

        //如果目标和 target 大于最大可能和或最小可能和，返回0
        if (target > sum || target < -sum) return 0;

        //创建dp数组，范围从 -sum 到 sum
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        //初始化 dp[0][sum] = 1, sum 是偏移量
        dp[0][sum] = 1; //什么都不取的方式来达到和为0 （索引偏移后的0即sum）

        //填充dp表
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                //分别计算加上当前数和减去当前数的情况
                int add = (j - nums[i - 1] >= 0) ? dp[i - 1][j - nums[i - 1]] : 0;
                int subtract = (j + nums[i - 1] <= 2 * sum) ? dp[i - 1][j + nums[i - 1]] : 0;
                dp[i][j] = add + subtract;

            }
        }

        //返回目标和target的方法数，target 需要加上偏移量sum
        return dp[nums.length][target + sum];

    }

    /**
     * Comment:
     *
     * 回溯的话减不了枝，时间复杂度会到O（2^n）
     * 动态规划
     *
     */
}
