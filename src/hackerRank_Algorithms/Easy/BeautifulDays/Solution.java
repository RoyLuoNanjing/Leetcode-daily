package hackerRank_Algorithms.Easy.BeautifulDays;

public class Solution {
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int count = 0;
        for (int l = i; l <= j; l++) {
            int reverse = reverseDay(l);
            int abs = Math.abs(l - reverse);

            if (abs % k == 0) {
                count++;
            }
        }
        return count;
    }

    public static int reverseDay(int day) {
        //24
        int res = 0;
        while (day != 0) {
            res = res * 10 + day % 10;
            day = day / 10;
        }
        return res;
    }


    public static void main(String[] args) {
        beautifulDays(13,45,3);
    }
}
