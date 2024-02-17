package leetcode.medium.Q131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution_DynamicProgramming {
    public List<List<String>> partition(String s) {
        int n = s.length();

        //dp[i][j]表示从位置i到位置j的子串是否为回文串
        boolean [][] dp = new boolean[n][n];

        //初始化dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                //任意子串 s [j:i]如果两端相等，
                // 并且去掉两端字符后的子串 s[j+1 : i-1]也是回文串
                //或者该子串的长度小于等于2 （即 i - j <= 2）也是回文串
                //则将 dp[j][i] 设为true，表示从j 到 i的子串是回文串
                if (s.charAt(i) == s.charAt(j) && (i - j<=2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s,0,dp,path,result);
        return result;
    }

    //使用深度优先搜索（DFS）遍历所有可能的回文串组合
    private  void dfs (String s , int start, boolean[][] dp, List<String> path, List<List<String>> result){
        if (start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int end = start ; end < s.length();end ++){
            if (dp[start][end]){
                //如果从start到end的子串是回文串，将该子串加入路径中
                path.add(s.substring(start,end + 1));
                //递归处理剩余部分
                dfs(s, end + 1, dp, path, result);
                //回溯，移除最后加入的子串，尝试其他可能的回文串组合
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * Comment:
     * 动态规划 + 回溯
     * 有点难
     *
     */
}
