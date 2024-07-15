package hackerRank.Easy.RepeatedString;

public class Solution {
    public static long repeatedString(String s, long n) {
        // Write your code here
        long l = s.length();

        long i = n / l;
        long modu = n % l;

        int individual = 0;

        long count = 0;

        for (int j = 0; j < l; j++) {
            if (s.charAt(j) == 'a') {
                individual++;
            }
        }

        if (modu != 0) {
            for (int j = 0; j < modu; j++) {
                if (s.charAt(j) == 'a') {
                    count++;
                }
            }
        }

        count = count + individual * i;

        return count;
    }
}
