package hackerRank_Algorithms.Easy.HackerRankInAString;

public class Solution {
    public static String hackerrankInString(String s) {
        // Write your code here
        String str = "hackerrank";

        int index = 0;



            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == str.charAt(index)) {
                    index++;
                }
                if (index == str.length()) {
                    return "YES";
                }
            }

        String res = "NO";

        return res;
    }
}
