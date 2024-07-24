package hackerRank_Algorithms.Easy.ChocolateFeast;

public class Solution {
    public static int chocolateFeast(int n, int c, int m) {
        // Write your code here
        int num = n / c;

        int paper = num;

        while (paper >= m) {
            int left = paper % m;
            int newBars = paper / m;
            num += newBars;
            paper = left + newBars;

        }

        return num;
    }

}
