package leetcode.medium.Q647_PalindromicSubstrings;

public class Solution_DynamicProgramming {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // 遍历所有子串的长度
        for (int len = 1; len <= n; len++) {
            // 遍历所有起始点
            for (int start = 0; start <= n - len; start++) {
                // 计算结束点
                int end = start + len - 1;

                // 如果子串长度为1，则一定是回文子串
                if (len == 1) {
                    dp[start][end] = true;
                }
                // 如果子串长度为2，判断两个字符是否相等
                else if (len == 2) {
                    dp[start][end] = (s.charAt(start) == s.charAt(end));
                }
                // 如果子串长度大于2，使用状态转移方程，之前的要是回文，并且加上两段还要是回文
                else {
                    dp[start][end] = (s.charAt(start) == s.charAt(end)) && dp[start + 1][end - 1];
                }

                // 如果 dp[start][end] 为 true，说明这是一个回文子串
                if (dp[start][end]) {
                    count++;
                }
            }
        }

        return count;
    }
}
