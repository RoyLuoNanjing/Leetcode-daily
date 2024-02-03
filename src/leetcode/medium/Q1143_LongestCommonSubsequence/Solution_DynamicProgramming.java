package leetcode.medium.Q1143_LongestCommonSubsequence;

public class Solution_DynamicProgramming {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();


        //创建一个二维数组dp，其中dp[i][j]表示text1前i个字符与text2前j个字符的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];

        //填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果当前字符相同
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  //两个字符串同时加一个char，如果相等则在之前基础上+1
                } else {
                    //如果当前字符不同，取上方或左方的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // dp[m][n]即为最长公共子序列的长度
        return dp[m][n];
    }
    /**
     * Comment:
     * 首先int[]自动初始化全为0
     * 其次动态规划中如果相等则考虑左上+1
     * 不相等则考虑左和上的最大值
     *
     */
}
