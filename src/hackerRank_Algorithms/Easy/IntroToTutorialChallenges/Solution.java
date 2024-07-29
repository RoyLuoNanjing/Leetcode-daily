package hackerRank_Algorithms.Easy.IntroToTutorialChallenges;

import java.util.List;

public class Solution {

    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int res = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == V) {
                res = i;
                break;
            }
        }
        return res;
    }
}
