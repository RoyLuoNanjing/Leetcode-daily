package hackerRank.Easy.Birthday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int length = s.size();

        if ((length - m) < 0) return 0;
        int res = 0;

        for (int i = 0; i <= length - m; i++) {
            int count = 0;
            int sum = 0;
            int start = i;

            while (count < m) {
                sum += s.get(start);

                if (sum > d) {
                    break;
                }
                count++;
                start++;
            }

            if (sum == d){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>(Arrays.asList(4));
        birthday(s,4,1);

    }
}
