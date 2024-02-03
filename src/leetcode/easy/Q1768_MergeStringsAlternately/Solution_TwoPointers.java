package leetcode.easy.Q1768_MergeStringsAlternately;

public class Solution_TwoPointers {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer s = new StringBuffer();
        int l1 = word1.length() - 1;
        int l2 = word2.length() - 1;

        int p1 = 0;
        int p2 = 0;

        while (p1 <= l1 || p2 <= l2) {
            if (p1 <= l1) {
                s.append(word1.charAt(p1));
            }

            if (p2 <= l2) {
                s.append(word2.charAt(p2));
            }

            p1++;
            p2++;
        }
        return s.toString();
    }
    /**
     * Comment:
     * 双指针标准写法
     * StringBuffer线程安全但是慢于不安全的StringBuilder
     */
}
