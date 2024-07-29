package hackerRank_Algorithms.Medium.AbsolutePermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }

        if (n % (2 * k) != 0) {
            result.add(-1);
            return result;
        }

        boolean add = true;

        for (int i = 1; i <= n; i++) {
            if (add) {
                result.add(i + k);
            } else {
                result.add(i - k);
            }
            if (i % k == 0) {
                add = !add;
            }
        }

        return result;
    }

}

