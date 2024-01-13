package leetcode.medium.Q64_MinimumPathSum;

public class Solution_DP {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        //初始化第一行和第一列， 因为这两个方向的路径是固定的
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }


        //动态规划填充其余单元格
        //其原理实际上是判断一下从左边和上面过来哪个值最小，即加到当前坐标值上一次来判断到当前点最小路径是多少
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m-1][n-1];
    }


    /**
     * COMMENTS:
     * 动态规划
     * 此题实际上把每个坐标上的值都与从左和上面过来的最小值进行相加
     * 这样到最后一个点的时候实际上是最小的值
     */
}
