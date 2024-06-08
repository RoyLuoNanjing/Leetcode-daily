package leetcode.challenges.JPMorganChase.QuestionOne;

public class Solution {

    public static String getSmallestString(String word, String substr) {
        int wordLen = word.length(); // 获取word的长度
        int substrLen = substr.length(); // 获取substr的长度

        String result = null; // 初始化结果为null

        // 遍历所有可能的插入位置
        for (int i = 0; i <= wordLen - substrLen; i++) {
            StringBuilder candidate = new StringBuilder(word); // 创建一个可变字符串，因为后面还需要修改原字符串

            boolean canPlaceSubstr = true; // 标记是否可以在当前位置插入substr
            // 检查从当前位置开始的每一个字符是否匹配或为?
            for (int j = 0; j < substrLen; j++) {
                char wordChar = candidate.charAt(i + j);  //此时的char位置实际上是在i基础上再加上j
                char substrChar = substr.charAt(j);
                if (wordChar != '?' && wordChar != substrChar) {
                    canPlaceSubstr = false; // 如果不匹配且不是问号，则不能插入
                    break; // 退出循环
                }
            }

            // 如果可以插入substr
            if (canPlaceSubstr) {
                // 在当前位置插入substr（实际是将此处的字符一一替换）
                for (int j = 0; j < substrLen; j++) {
                    candidate.setCharAt(i + j, substr.charAt(j));
                }

                // 将剩余的?替换为a
                for (int k = 0; k < wordLen; k++) {
                    if (candidate.charAt(k) == '?') {
                        candidate.setCharAt(k, 'a');
                    }
                }

                // 转换为字符串形式
                String candidateStr = candidate.toString();

                // 如果result为空或者candidateStr字典序小于result
                if (result == null || candidateStr.compareTo(result) < 0) {
                    result = candidateStr; // 更新result
                }
            }
        }

        // 如果没有找到合适的字符串，返回-1
        return result == null ? "-1" : result;
    }

    public static void main(String[] args) {
        String word1 = "as?b?e?gf"; // 示例输入1
        String substr1 = "dbk"; // 示例输入1
        System.out.println(getSmallestString(word1, substr1)); // 输出: asdbkeagf

        String word2 = "????"; // 示例输入2
        String substr2 = "z"; // 示例输入2
        System.out.println(getSmallestString(word2, substr2)); // 输出: zzaa

        String word3 = "????"; // 示例输入3
        String substr3 = "abc"; // 示例输入3
        System.out.println(getSmallestString(word3, substr3)); // 输出: abc
    }
}