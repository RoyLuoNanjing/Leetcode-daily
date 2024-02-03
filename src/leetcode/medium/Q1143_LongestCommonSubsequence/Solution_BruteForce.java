package leetcode.medium.Q1143_LongestCommonSubsequence;

public class Solution_BruteForce {
    public int longestCommonSubsequence(String text1, String text2) {
        int count = 0;

        int l1 = text1.length() - 1;
        int l2 = text2.length() - 1;

        //如果两个text一样长度
        if (text1.equals(text2)) return l1 + 1;

        String longText;
        String shortText;
        if (l1 > l2) {
            longText = text1;
            shortText = text2;
        } else {
            longText = text2;
            shortText = text1;
        }

        boolean findIt = false;
        int start = 0;
        for (int i = 0; i <= shortText.length() - 1; i++) {

            for (int j = start; j <= longText.length() - 1; j++) {
                if (shortText.charAt(i) == longText.charAt(j)) {
                    start = j + 1;
                    findIt = true;
                    count++;
                    break;
                } else if (findIt == false) {
                    start = 0;
                } else {
                    start = j + 1;
                }
            }
        }

        return count;
    }
    /**
     * Comment:
     * 注意：这个暴力解法解不出所有的答案
     * 目前最终问题是：
     text1 = "oxcpqrsvwf"
     text2 = "shmtulqrypy"
     当识别到text2的p的时候，系统认为其是最优解而忽视了后面还有qr
     */
}
