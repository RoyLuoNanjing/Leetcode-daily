package hackerRank.Easy.BreakingRecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int minRecord = 0;
        int maxRecord = 0;

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > maxScore){
                maxScore = scores.get(i);
                maxRecord++;
            }

            else if  (scores.get(i) < minScore){
                minScore = scores.get(i);
                minRecord++;
            }
        }
        res.add(maxRecord);
        res.add(minRecord);

     return res;
    }
}
