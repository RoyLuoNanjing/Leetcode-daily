package hackerRank_Algorithms.Medium.CommonChild;

public class Solution_DP {
    public static int commonChild(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a DP table with dimensions (n+1) x (m+1)
        int[][] dp = new int[n+1][m+1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, take the value from the top-left diagonal and add 1
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // If they don't match, take the maximum value from the cell above or to the left
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // The result is in the bottom-right cell of the table
        return dp[n][m];
    }
}
