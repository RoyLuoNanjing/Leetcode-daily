package leetcode.medium.Q72_EditDistance;

public class Solution_DynamicPrograming {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int [][] dp= new int[n1 + 1][n2 + 1];

        //第一行
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        //第一列
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }


        for(int i =1;i<=n1;i++){
            for(int j = 1; j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    //此时两个遍历的string末尾数相同，不需要+1
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    //找到在前面的基础上添加删除还是替换能获得最小的解，+1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
            }
        }
        return dp[n1][n2];
    }

    /**
     * Comment:
     * 这题如果用dp一定要清楚一个概念，
     * 首先，如果确定一个字符转到另一个字符串最优步数是n，那么原字符串变长一位后，最优步数一定是n+1
     * -比如hors变成cors的最优解和horse变成cors的最优解一定相差1
     *
     * 其次，二维数组展开以后每一个都在记录从word1片段到word2片段，增删改都是一次变化
     *    ''  r  o  s
     *  '' 0  1  2  3
     *  h  1
     *  o  2
     *  r  3
     *  s  4
     *  e  5
     *
     *  可以得出一个结论：
     *  dp[i-1][j-1]表示的是替换操作，此时不需要+1
     *  dp[i][j-1] 表示的是删除操作，
     *  dp[i-1][j] 表示的是添加操作
     *
     *  dp[i][j]记录的就是word1从i位置转换到word2j位置的最优解
     *    ''  r  o  s
     *  '' 0  1  2  3
     *  h  1  1  2  3
     *  o  2  2  1  2
     *  r  3  2  2  2
     *  s  4  3  3  2
     *  e  5  4  4  3
     *
     *
     *
     *  有点难度！！
     */
}
