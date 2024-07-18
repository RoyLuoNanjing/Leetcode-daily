package hackerRank_Algorithms.Medium.ClimbingLeaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        List<Integer> res = new ArrayList<>();

        ArrayList<Integer> rankedSet = new ArrayList<>();
        rankedSet.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1)) ) {
                rankedSet.add(ranked.get(i));
            }
        }


        //二分查找 提高搜寻速度
        for (Integer score : player) {
            int position = Collections.binarySearch(rankedSet, score, Collections.reverseOrder());
            if (position < 0) {
                position = -position - 1;
            }
            res.add(position + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 90, 90, 80, 75, 60));
        List<Integer> player = new ArrayList<>(Arrays.asList(50, 65, 77, 90, 102));

        climbingLeaderboard(ranked, player);
    }
}
