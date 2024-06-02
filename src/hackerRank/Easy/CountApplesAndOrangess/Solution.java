package hackerRank.Easy.CountApplesAndOrangess;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        List<Integer> appleDistanceList =  apples.stream().map(apple -> apple + a ).collect(Collectors.toList());
        List<Integer> orangeDistanceList =  oranges.stream().map(orange ->  orange + b ).collect(Collectors.toList());

        int countApple = 0;
        int countOrange = 0;

        for (Integer integer : appleDistanceList) {
            if (integer >= s && integer <= t ){
                countApple ++;
            }
        }

        for (Integer integer : orangeDistanceList) {
            if (integer >=s && integer <= t ){
                countOrange ++;
            }
        }


        System.out.println(countApple);
        System.out.println(countOrange);

    }
}
