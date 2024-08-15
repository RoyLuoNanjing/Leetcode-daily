package hackerRank_Algorithms.Easy.TheLoveLetterMystery;

public class Solution {
    public static int theLoveLetterMystery(String s) {
        // Write your code here
        int l = s.length();
        int count = 0;

        for (int i = 0; i < l/2; i++) {
            if (s.charAt(i) != s.charAt(l - 1 - i)) {
                count += Math.abs(s.charAt(i) - s.charAt(l - 1 - i));
            }
        }
        return count;
    }

}
