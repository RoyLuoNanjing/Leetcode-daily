package leetcode.medium.Q62_UniquePaths;

public class Solution_DynamicProgramming {
    public int uniquePaths(int m, int n) {
        if (m * n == 1) return 1;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;

        //横向和纵向都只会是1，因为不管走到哪一点，路径都只有一条
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        //此时的路径数应该是从上和左过来的路径和
        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                dp[y][x] = dp[y - 1][x] + dp[y][x - 1];
            }
        }
        //最后一个点会记录路径总数
        return dp[m - 1][n - 1];
    }

    /**
     * COMMENTS:
     * 和pascal's triangle很像
     * 虽是medium但是只要思路对就很像
     */
}
