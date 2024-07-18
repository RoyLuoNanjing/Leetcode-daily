package hackerRank_Algorithms.Easy.GradingStudents;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        List<Integer> res = new ArrayList<>();

        for (Integer grade : grades) {
            int value = grade % 5;

            if ((40 - grade)>= 3 ) {
                res.add(grade);
                continue;
            }

            if ((5 - value) >= 3){
                res.add(grade);
                continue;
            }

            if ((5-value) < 3){
                res.add(grade +(5 - value));
                continue;
            }
        }

        return res;

    }
}
