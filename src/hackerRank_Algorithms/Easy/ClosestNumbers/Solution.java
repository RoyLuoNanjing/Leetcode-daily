package hackerRank_Algorithms.Easy.ClosestNumbers;

import java.util.*;

public class Solution {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> l = new ArrayList<>();
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.size(); i++) {
            int absoluteDifference = Math.abs(arr.get(i) - arr.get(i - 1));

            if (absoluteDifference < min) {
                min = absoluteDifference;
                l.clear();
                l.add(arr.get(i - 1));
                l.add(arr.get(i));
            } else if (absoluteDifference == min) {
                l.add(arr.get(i - 1));
                l.add(arr.get(i));
            }
        }

        return l;
    }

}
