package hackerRank.Easy.SherlockAndSquares;

public class Solution {
    public static int squares(int a, int b) {
        // Write your code here
        double squareA = Math.sqrt(a);
        double squareB = Math.sqrt(b);

        int startA = (int) Math.ceil(squareA);
        int startB = (int) Math.floor(squareB);

        return startB - startA + 1;
    }
}
