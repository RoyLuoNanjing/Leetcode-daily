package leetcode.medium.Q122_BestTimeToBuyAndSellStockII;

public class Solution_DynamicProgramming {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        //横向index 0表示不持股，1表示持股
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0]; //持股即为负数

        for (int i = 1; i < n; i++) {
            /**
             * 如果今天结束手里没有持有股票，则两种情况
             * 1.昨天卖掉了，今天也没有买
             * 2.昨天没有卖，今天用当天价格卖出
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /**
             * 如果今天结束手里持有股票，则两种情况
             * 1.昨天卖掉了，今天继续买
             * 2.昨天没有卖，今天还是没有卖
             */
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //注意顺序
        }

        //最后一天手里没有任何股票的时候，即考虑了所有最优的可能得出的最佳值
        return dp[n - 1][0];
    }
    /**
     * Comment:
     * 重点需要考虑状态转移的条件
     * 当天最后是否手里有股票，有则为0，没有则为1，建立坐标系
     *
     */

    // 动态规划表
// prices = [3, 4, 5, 1, 3]
// 天数 / 状态 | 不持有股票 (dp[i][0]) | 持有股票 (dp[i][1])
// 第1天        | 0                        | -3
// 第2天        | 1                        | -3
// 第3天        | 2                        | -3
// 第4天        | 2                        | 1
// 第5天        | 4                        | 1
}
