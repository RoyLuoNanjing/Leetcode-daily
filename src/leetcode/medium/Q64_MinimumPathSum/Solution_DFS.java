package leetcode.medium.Q64_MinimumPathSum;

public class Solution_DFS {
    int minValue = Integer.MAX_VALUE;
    int x = 0;
    int y = 0;

    int height;
    int width;

    public int minPathSum(int[][] grid) {
        height = grid.length - 1;
        width = grid[0].length - 1;

        dfs(x, y, 0, grid);
        return minValue;
    }

    public void dfs(int x, int y, int addUp, int[][] grid) {
        if (x > width || y > height) return;


        //如果累加的值已经超过当前最短值则直接return
        if (addUp > minValue) {
            //回到上一个节点时的累加值
            addUp = addUp - grid[y][x];
            return;
        }
        //累加
        addUp = addUp + grid[y][x];
        dfs(x + 1, y, addUp, grid);
        dfs(x, y + 1, addUp, grid);
        //到最后一个点的时候，看一下是否是最小值
        if (x == width && y == height && addUp < minValue) {
            minValue = addUp;
        }

    }

    /**
     * COMMENTS:
     * DFS即使剪枝以后还是会2/62个测试用例超时
     * 应该使用动态规划
     */
}
