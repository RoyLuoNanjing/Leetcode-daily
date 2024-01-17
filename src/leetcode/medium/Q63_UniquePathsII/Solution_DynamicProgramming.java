package leetcode.medium.Q63_UniquePathsII;

public class Solution_DynamicProgramming {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0; //开头是路障则要退出
        if (obstacleGrid[0][0] == 0 && m == 1 && n == 1) return 1; //1*1无路障可以直接通过

        //纵向把路障1出现之前的值全部变成1，后面的则要全部保证是0
        //此处用flag做切换
        boolean flagI = false;
        for (int i = 1; i < m; i++) {
            //如果还没遇到第一个路障
            if(!flagI){
                if (obstacleGrid[i][0] == 1) {
                    obstacleGrid[i][0] = 0;
                    flagI=true;
                } else {
                    obstacleGrid[i][0] = 1;
                }
            }
            //遇到了第一个路障，后面的所有路都走不通
            else{
                obstacleGrid[i][0] = 0;
            }
        }

        //同理处理一下横向
        boolean flagJ = false;
        for (int j = 1; j < n; j++) {
            if(!flagJ){
                if (obstacleGrid[0][j] == 1) {
                    obstacleGrid[0][j] = 0;
                    flagJ=true;
                } else {
                    obstacleGrid[0][j] = 1;
                }
            }else {
                obstacleGrid[0][j] = 0;
            }
        }

        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                //如果是路障，则将值变成0
                if (obstacleGrid[y][x] == 1) {
                    obstacleGrid[y][x] = 0;
                } else {
                    //否则是相加
                    obstacleGrid[y][x] = obstacleGrid[y - 1][x] + obstacleGrid[y][x - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
    /**
     * COMMENTS:
     * 题目不难，但需要考虑一些边界条件
     */
}
