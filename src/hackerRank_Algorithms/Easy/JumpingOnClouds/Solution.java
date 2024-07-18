package hackerRank_Algorithms.Easy.JumpingOnClouds;

public class Solution {
    static int jumpingOnClouds(int[] c, int k) {

        int energy = c[0] == 1 ? 103 : 101;
        int start = 0;
        boolean isBackToZero = false;
        int n = c.length;
        while (!isBackToZero) {

            if (c[start] == 1) {
                energy -= 2;
            }
            energy--;

            start = (k + start) % n;
            if (start == 0) {
                isBackToZero = true;
            }
        }

        return energy;
    }
}
