package leetcode.medium.Q322_CoinChange;

import java.util.Arrays;

public class Solution_DynamicProgramming {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //构建一个array，来记录每一个amount下的最优值
        int[] dp = new int[amount + 1];

        //每一个dp值替换为max，用于后面寻找最小值
        Arrays.fill(dp, max);

        //初始化
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    //前者为当前的硬币数量，后者为在没有这个硬币时的最优数量+1（加上本硬币）
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //最后有可能最佳解还是达不到amount的要求，则为-1，否则取最后一个值
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Comment:
     * 关键点在于foreach 遍历里面 dp[i - coin] + 1 的想法，将此时的amount减去coin面值
     * 去寻找那个面值下的最优解
     * 此外还要注意用Arrays.fill(dp, max)将所有的值全部初始化为最大值
     */
}
