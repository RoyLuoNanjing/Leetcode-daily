package hackerRank.Medium.NonDivisibleSubset;

import java.util.List;

public class Solution {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] remainderCounts = new int[k];
        //计算每个余数的频率
        for (int num : s
        ) {
            remainderCounts[num % k]++;
        }

        //特殊情况：余数为0的数最多选择一个
        int result = Math.min(remainderCounts[0], 1);

        //遍历1到k/2的余数
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                result += Math.max(remainderCounts[i], remainderCounts[k - i]);
            } else {
                //余数等于k - i 的情况，当k是偶数时
                result += 1;
            }
        }
        return result;
    }
}
