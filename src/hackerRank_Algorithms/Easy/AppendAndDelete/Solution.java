package hackerRank_Algorithms.Easy.AppendAndDelete;

public class Solution {
    public static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;

        // 找到两个字符串的公共前缀长度
        while (commonLength < s.length() && commonLength < t.length() && s.charAt(commonLength) == t.charAt(commonLength)) {
            commonLength++;
        }

        // 计算要删除和追加的操作数
        int totalOperations = (s.length() - commonLength) + (t.length() - commonLength);

        // 判断是否可以在k步内完成操作
        if (k == totalOperations || (k >= s.length() + t.length()) || (k > totalOperations && (k - totalOperations) % 2 == 0)) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
