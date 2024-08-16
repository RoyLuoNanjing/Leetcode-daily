package leetcode.medium.Q151_ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(temp);
                //保证空格不会出现两次
                if (i + 1 <= s.length() - 1 && s.charAt(i + 1) != ' ') {
                    sb.append(' ');
                }
                //清空temp
                temp.setLength(0);
            } else {
                temp.insert(0, s.charAt(i) + ' ');
            }
        }
        sb.append(temp);
        return sb.toString().trim();
    }
}
