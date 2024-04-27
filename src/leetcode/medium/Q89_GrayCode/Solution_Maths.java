package leetcode.medium.Q89_GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_Maths {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        //生成从0到2^n - 1 的格雷码
        //1 << n 的结果是 2^n。这是因为每向左移一位相当于乘以2，移动 n 位就是乘以 2^n
        int count = 1 << n;
        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;

        /**
         * 在生成格雷码的表达式 i ^ (i >> 1) 中：
         *
         * i 表示当前的自然顺序数。
         * i >> 1 表示将 i 的二进制表示向右移动一位。
         * 通过这样的移位，我们可以得到每个数与其右移一位后的数进行异或操作（^）的结果。
         * 异或操作（^）会比较两个数的每一位，如果相同则结果为 0，不同则为 1。因此，i ^ (i >> 1) 就能生成一个新的数，
         * 其特点是与原数 i 相比，只有一位二进制位不同，这正是格雷码序列的要求。
         */

        /**
         * Comment:
         * 其实思路就是利用这种格雷码的转换(i ^ (i >> 1)，可以给连续的自然数的不连续的二进制提供一个新的数
         * 满足题目得到要求
         */

    }

}
