package hackerRank.Easy.JumpingOnCloudsII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int l = c.size();

        int count = 0;
        int start = 0;

        while (start < l - 2) {
            if (c.get(start + 2) == 1) {
                start++;
            } else {
                start += 2;
            }
            count++;
        }
        if (start != l - 1) count++;

        return count;
    }
}
