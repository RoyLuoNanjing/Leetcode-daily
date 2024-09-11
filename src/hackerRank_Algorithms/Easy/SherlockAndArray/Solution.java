package hackerRank_Algorithms.Easy.SherlockAndArray;

import java.util.List;

public class Solution {
    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int len = arr.size();


        int total = 0;

        for (int i = 0; i < len; i++) {
            total += arr.get(i);
        }

        int leftTotal = 0;
        int rightTotal = total;

        String ans = "NO";

        if (leftTotal == rightTotal -arr.get(0) ) return "YES";


        for (int i = 1; i < len; i++) {
            leftTotal += arr.get(i - 1);
            rightTotal = total - leftTotal - arr.get(i);

            if (rightTotal < leftTotal) {
                break;
            } else if (rightTotal == leftTotal) {
                ans = "YES";
            }
        }

        return ans;
    }
}
