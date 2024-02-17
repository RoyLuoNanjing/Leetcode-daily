package leetcode.medium.Q518_CoinChangeII;

public class Solution_DynamicProgramming {
    public int change(int amount, int[] coins) {
        //创建一个数组dp，dp[i]表示凑成总金额i的硬币组合数
        int[] dp = new int[amount + 1];

        //凑成总金额为0的组合数为1
        dp[0] = 1;

        //遍历硬币数组
        for (int coin : coins
        ) {
            //对于每一种硬币，遍历所有的可能
            for (int i = coin; i <= amount; i++) {
                //更新dp数组：当前金额i可以由之前金额为i - coin的组合数加上当前硬币得到
                dp[i] += dp[i - coin];
            }

        }
        //返回凑成总金额amount的组合数
        return dp[amount];
    }
    /**
     * Comment:
     * 有点想法但是思路对不上
     */
}
