package leetcode.easy.Q2605_FormSmallestNumberFromTwoDigitArrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        //对两个数组排序
        int[] sorted1 = Arrays.stream(nums1).sorted().toArray();
        int[] sorted2 = Arrays.stream(nums2).sorted().toArray();

        //两个数组最小值
        int minNum1 = sorted1[0];
        int minNum2 = sorted2[0];

        //暴力双层循环来判断是否存在相同的数，第一个找到的为最小的相同数
        for (int k : sorted1) {
            for (int i : sorted2) {
                if (k == i) {
                    return i;
                }
            }
        }
        //如果没有则要进行运算
        return Math.min(minNum1, minNum2) * 10 + Math.max(minNum1, minNum2);
    }

    /**
     * Comment:
     * 暴力解法
     */
}
