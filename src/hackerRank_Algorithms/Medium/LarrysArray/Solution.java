package hackerRank_Algorithms.Medium.LarrysArray;

import java.util.List;

public class Solution {

    /*
    在解决“Larry's Array”问题时，通过计算数组中的逆序对的数量可以帮助我们判断是否能通过三元旋转（每次旋转三个连续的元素）将数组排序。
    根据问题的性质，如果逆序对的数量是偶数，那么数组是可以通过三元旋转排序的；如果是奇数，则不可以。
     */
    public static String larrysArray(List<Integer> A) {
        int inversions = countInversions(A);
        if (inversions % 2 == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static int countInversions(List<Integer> A) {
        int inversions = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
