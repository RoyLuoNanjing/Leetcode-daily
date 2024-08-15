package hackerRank_Algorithms.Easy.FindTheMedian;

import java.util.Collections;
import java.util.List;

public class Solution {

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        return arr.get(arr.size() / 2);
    }
}
