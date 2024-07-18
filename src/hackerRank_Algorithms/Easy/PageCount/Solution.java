package hackerRank_Algorithms.Easy.PageCount;

public class Solution {

    public static int pageCount(int n, int p) {
        // Write your code here

        int front;
        int back;

        back = (n - p) / 2;
        if ((p - 1) % 2 == 0) {
            front = (p - 1) / 2;

            if ((n - p) == 1) {
                back = 1;
            }
        } else {
            front = 1 + (p - 1) / 2;

            if ((n - p) == 1) {
                back = 0;
            }
        }


        if (p == 1) {
            front = 0;
        }


        return Math.min(front, back);

    }
}
