package hackerRank_Algorithms.Easy.StringConstruction;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int stringConstruction(String s) {
        // Write your code here
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                count++;
            }
        }
        return count;
    }
}
