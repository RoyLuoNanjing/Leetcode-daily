package leetcode.easy.Q2644_FindTheMaximumDivisibilityScore;

import java.util.Arrays;

public class Solution_Array {

    /* Input: nums = [20,14,21,10], divisors = [5,7,5]
        Output: 5
        Explanation: The divisibility score for every element in divisors is:
        The divisibility score of divisors[0] is 2 since nums[0] and nums[3] are divisible by 5.
        The divisibility score of divisors[1] is 2 since nums[1] and nums[2] are divisible by 7.
        The divisibility score of divisors[2] is 2 since nums[0] and nums[3] are divisible by 5.
        Since divisors[0], divisors[1], and divisors[2] all have the maximum divisibility score, we return the minimum of them (i.e., divisors[2]).
*/
    public int maxDivScore(int[] nums, int[] divisors) {

        int maxCount = 0;
        int selectedDivisor = -1;

        //从小到大排列
        Arrays.sort(divisors);

        for (int i = 0; i < divisors.length ; i++) {
            //防止重复计算
            if (i > 0 && divisors[i] == divisors[i - 1]) continue;

            int count = 0;
            for (int j = 0; j < nums.length ; j++) {
                int times = nums[j] % divisors[i];
                if (times == 0) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                selectedDivisor = i;
            }

        }
        return selectedDivisor == -1 ? divisors[0] : divisors[selectedDivisor];
    }
}
