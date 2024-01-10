package leetcode.easy.Q20_ValidParentheses;

public class Solution_Replace {
    public boolean isValid(String s) {
        while (!s.isEmpty()) {
            String replacedString = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");

            if (replacedString.length() == s.length() ){
                return false;
            }
            s = replacedString;
        }
        return true;

    }

    /**
     * COMMENTS:
     暴力解法，非常slow

     */
}
