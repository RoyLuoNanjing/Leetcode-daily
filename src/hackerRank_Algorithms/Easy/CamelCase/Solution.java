package hackerRank_Algorithms.Easy.CamelCase;

public class Solution {
    public static int camelcase(String s) {
        // Write your code here
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) count++;
        }

        return count;
    }
}
