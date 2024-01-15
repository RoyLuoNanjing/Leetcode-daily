package leetcode.easy.Q746_MinCostClimbingStairs;

public class Solution_DynamicProgramming {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length ; i++) {
            cost[i] = cost[i] + Math.min(cost[i-1],cost[i-2]);

        }
        return Math.min(cost[length-1],cost[length-2]);
    }
    /**
     * Comment:
     * 官方解答比较诡异
     * 我这边用dp直接对原来的数组进行修改
     * 最后最小值一定是倒数第一个和倒数第二个之间的最小值
     * 其实此题要注意的是一定从i=2的时候开始遍历
     */
}
