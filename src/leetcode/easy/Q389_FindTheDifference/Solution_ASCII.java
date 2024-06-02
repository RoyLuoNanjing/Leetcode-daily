package leetcode.easy.Q389_FindTheDifference;

public class Solution_ASCII {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }

        return (char) (at - as);
    }

    /**
     * Comment:
     * 每一个char都是可以累加的int
     * 对应相应的ASCII码
     * 如果我们能得出前后的Int的差值，则这个int在强行转以后会变成对应的char
     */
}
