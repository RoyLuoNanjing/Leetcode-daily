package hackerRank_Algorithms.Easy.AlternatingCharacters;

public class Solution {
    public static int alternatingCharacters(String s) {
        // Write your code here

        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}
