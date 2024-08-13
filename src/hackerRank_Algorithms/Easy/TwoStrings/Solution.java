package hackerRank_Algorithms.Easy.TwoStrings;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }

        for (char c : set1
        ) {
            if (set2.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }
}
