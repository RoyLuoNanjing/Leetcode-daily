package hackerRank.Easy.HurdleRace;

import java.util.List;

public class Solution {
    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int max = 0;

      for(Integer each : height) {
          if (each > k){
              max = Math.max(each, max);
          }
      }

      return max == 0 ? max : max - k;
    }
}
