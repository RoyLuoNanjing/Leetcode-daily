package hackerRank.Easy.FindDigits;

public class Solution {

    public static int findDigits(int n) {
        // Write your code here
        int count = 0;
        int refer = n;

        while (n != 0) {
            int modu = n % 10;
            if (modu != 0) {
                int modu2 = refer % modu;

                if (modu2 == 0) {
                    count++;
                }
            }

            n = n / 10;
        }
        return count;
    }
}
