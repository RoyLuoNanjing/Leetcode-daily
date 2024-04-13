package leetcode.easy.Q977_SquaresOfASortedArray;

import java.util.Arrays;

public class Solution_TwoPointers {
    /*
    Example 1:
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100]
     */
    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];

        int l = 0;
        int r = size - 1;

        int count = 0;
        while (count < size) {
            int rValue = nums[r] * nums[r];
            int lValue = nums[l] * nums[l];
            if (rValue > lValue) {
                res[size - count - 1] = rValue;
                r--;
            } else {
                res[size - count - 1] = lValue;
                l++;
            }
            count++;
        }
        return res;
    }
    /**
     * Comment:
     * 用双指针的方法，从两头往里面收缩
     * 倒序的把平方值最大的一个插入列表中
     */
}
