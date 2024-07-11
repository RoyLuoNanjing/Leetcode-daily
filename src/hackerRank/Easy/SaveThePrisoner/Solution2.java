package hackerRank.Easy.SaveThePrisoner;

public class Solution2 {
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        m = m % n;

        int res = (s + m - 1) % n;


        return res == 0? n : res;
    }
}
