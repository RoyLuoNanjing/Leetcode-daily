package leetcode.medium.Q1049_LastStoneWeightII;

public class Solution_DynamicProgramming {
    public int lastStoneWeightII(int[] stones) {
        //此题的一个动态规划思路是先找到石头总重 sum
        //然后找到最接近 sum/2 ,即总重一半的组合
        //记住不要超过一半，这样就是最佳的抵消方案
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int m = sum / 2;
        //这里是记录找到总重一半的路上，每一个重量是否具有一个组合的可能
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        //遍历每一块石头
        for (int weight : stones) {
            //从大到小去遍历，因为我们要考虑dp[j-weight]来避免覆盖
            for (int j = m; j >= weight; j--) {
                //前者指如果已经有其他石头满足了这个可能，那这个石头则不需要考虑了
                //后者指如果没算这个石头，是否可以找到组合让其等于j- weight，那考虑这个石头则一定满足j
                dp[j] = dp[j] || dp[j - weight];

            }
        }

        //从大到小去遍历，最接近一般重量的，在抵消以后一定是最小值
        for (int j = m; ; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

    /**
     * Comment:
     * 题目很有意思
     * 思路全在代码注释上面
     *
     */
}
