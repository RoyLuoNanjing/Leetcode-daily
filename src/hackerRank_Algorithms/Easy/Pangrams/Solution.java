package hackerRank_Algorithms.Easy.Pangrams;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static String pangrams(String s) {
        // Write your code here
        Set<Character> set = new HashSet<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == ' '){
                continue;
            }
            set.add(ch);
            if (set.size() > 25) {
                return "pangram";
            }
        }

        return "not pangram";
    }
}
