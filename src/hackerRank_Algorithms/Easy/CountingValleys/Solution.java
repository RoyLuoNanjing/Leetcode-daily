package hackerRank_Algorithms.Easy.CountingValleys;

public class Solution {
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int altitude = 0;
        int count = 0;


        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'D'){

                if (altitude == 0){
                    count++;
                }
                altitude--;
            }
            if (path.charAt(i) == 'U'){
                altitude++;

                if (altitude == 0){
                    count++;
                }
            }

        }

        return count/2;
    }
}
