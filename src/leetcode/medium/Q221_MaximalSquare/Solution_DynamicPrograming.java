package leetcode.medium.Q221_MaximalSquare;

public class Solution_DynamicPrograming {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        //遍历每一个点，构建dp数组
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                //只有当前位置是'1'时，才考虑正方形的可能性
                if (matrix[i - 1][j - 1] == '1') {
                    //状态转移方程：取决于左边、上面和左上角的最小值
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    //更新可能得边长
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    /**
     * COMMENTS:
     * 主旨是通过动态规划数组来记录每一个点能形成的长方形最大边长
     * 主要判断是看左，上，左上的情况，去最小值+1,
     */
}
