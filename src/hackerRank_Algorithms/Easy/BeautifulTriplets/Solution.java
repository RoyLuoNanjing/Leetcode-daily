package hackerRank_Algorithms.Easy.BeautifulTriplets;

import java.util.List;

public class Solution {
    public static int beautifulTriplets(int d, List<Integer> arr) {
        int[] l = new int[100001];

        for (int num : arr) {
            l[num]++;
        }

        int count = 0;
        int prev = -1;
        for (int num : arr) {
            if (num + d < l.length && num + 2 * d < l.length && num != prev) {
                count += l[num] * l[num + d] * l[num + 2 * d];

            }
            prev = num;
        }

        return count;
    }


    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 6, 7, 7, 8, 10, 12, 13, 14, 19);
        int d = 3;
        beautifulTriplets(d, arr);
    }
}
