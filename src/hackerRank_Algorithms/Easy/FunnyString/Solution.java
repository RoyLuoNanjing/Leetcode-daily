package hackerRank_Algorithms.Easy.FunnyString;

public class Solution {
    public static String funnyString(String s) {
        // Write your code here

        String res = "Funny";
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(s.charAt(s.length() - i) - s.charAt(s.length() - i - 1))) {
                res = "Not Funny";
                break;
            }
        }
        return res;
    }
}
