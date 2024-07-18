package hackerRank_DataStructures.Easy.TwoDArraysDS;

import java.util.List;

public class Solution {
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size() - 2; i++) {

            for (int j = 0; j < arr.get(0).size() - 2; j++) {
                int count = 0;
                count += arr.get(i).get(j);
                count += arr.get(i).get(j + 1);
                count += arr.get(i).get(j + 2);
                count += arr.get(i + 1).get(j + 1);
                count += arr.get(i + 2).get(j);
                count += arr.get(i + 2).get(j + 1);
                count += arr.get(i + 2).get(j + 2);
                max = Math.max(max, count);
            }


        }
        return max;
    }
}
