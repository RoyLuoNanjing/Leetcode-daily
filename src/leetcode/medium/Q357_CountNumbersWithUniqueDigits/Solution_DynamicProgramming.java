package leetcode.medium.Q357_CountNumbersWithUniqueDigits;

public class Solution_DynamicProgramming {
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


    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;//如果n为0，只有一个数字0是合法的

        int[] dp = new int[n + 1];
        dp[0] = 1; // 0位数字只有一个，即为0
        dp[1] = 10; // 1位数字有10个

        //从2位数字开始计算，直到n位数字
        for (int i = 2; i <= n; i++) {
            dp[i] = 9;
            int availableNumbers = 9;// 除了首位已经选了一个数字，剩下可用的数字有9个
            int currentDigits = 1;
            //计算在每个位数能凑成多少个unique数
            while (currentDigits < i) {
                dp[i] *= availableNumbers;
                availableNumbers--;
                currentDigits++;
            }
        }

        //计算所有的合法数字总数
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += dp[i];
        }
        return total;
    }

            /**
             * Comment:
             * 动态规划  主要思路是排列组合不同长度的数，最后进行累加
             * 这种方法时间复杂度只有0(n)， 会更快点
             */

}
