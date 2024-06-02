package leetcode.medium.Q357_CountNumbersWithUniqueDigits;

public class Solution_Backtracking {
    /*
    Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10^n.
        Example 1:

        Input: n = 2
        Output: 91
        Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
        Example 2:

        Input: n = 0
        Output: 1

     */

    private int count = 1; // 初始化为1，因为数字0是一个有效的唯一数

    public int countNumbersWithUniqueDigits(int n) {
        //特殊情况
        if (n == 0) return 1; // 只有数字0
        if (n == 1) return 10; //全部都是唯一的

        //从1到9开始，避免以0为开头的多位数
        for (int i = 1; i < 10; i++) {
            boolean[] used = new boolean[10]; // 标记哪些数字被使用
            used[i] = true;
            backtrack(i, n, used);
        }
        return count;
    }

    private void backtrack(int currentNumber, int n, boolean[] used) {
        //当前数字没有高于n， 记录结果
        if (Integer.toString(currentNumber).length() <= n) {
            count++;
        }
        // 超出n位时停止递归
        if (Integer.toString(currentNumber).length() == n) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) { // 如果数字i没有被使用
                used[i] = true;
                backtrack(currentNumber * 10 + i, n, used);
                used[i] = false;
            }
        }
    }
}
