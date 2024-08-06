package hackerRank_Algorithms.Easy.MarsExploration;

public class Solution {
    public static int marsExploration(String s) {
        // Write your code here
        String str = "SOS";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != str.charAt(i % 3)) {
                count++;
            }
        }
        return count;
    }
}
