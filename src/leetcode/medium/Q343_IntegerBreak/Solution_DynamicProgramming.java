package leetcode.medium.Q343_IntegerBreak;

public class Solution_DynamicProgramming {
    public int integerBreak(int n) {
        //创建dp数组，其中dp[i]表示将正整数i拆分成至少两个正整数的和后的最大乘积
        int[] dp = new int[n + 1];

        //初始化dp数组的前两个值
        dp[1] = 0;

        //从2开始计算dp值
        for (int i = 0; i <= n; i++) {
            //尝试每个可能得拆分点
            for (int j = 1; j < i; j++) {
                //计算不再拆分和继续拆分的两种情况的最大值,但是要注意dp[i]一直根据j的变化而变化
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        //返回dp[n]即为将整数n拆分后的最大乘积
        return dp[n];
    }
}
