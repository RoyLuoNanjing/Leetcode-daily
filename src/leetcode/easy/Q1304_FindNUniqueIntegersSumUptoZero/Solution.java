package leetcode.easy.Q1304_FindNUniqueIntegersSumUptoZero;

public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int half = n / 2;

        // 生成一对一对的正负数填充数组
        for (int i = 0; i < half; i++) {
            res[i] = i + 1; // 正数
            res[n - 1 - i] = -(i + 1); // 对应的负数
        }

        // 如果 N 是奇数，中间位置置为 0
        if (n % 2 != 0) {
            res[half] = 0;
        }

        return res;
        /**
         * Comment:
         * American Express
         */
    }
}
