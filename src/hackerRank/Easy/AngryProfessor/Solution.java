package hackerRank.Easy.AngryProfessor;

import java.util.List;

public class Solution {

    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here
        int count = 0;

        for (Integer at : a) {
            if (at <= 0) count++;
        }

        return count > k ? "NO" : "YES";
    }
}
