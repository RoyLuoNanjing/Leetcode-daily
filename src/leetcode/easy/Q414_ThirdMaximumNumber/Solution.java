package leetcode.easy.Q414_ThirdMaximumNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        /**
         * sort并且reverse了一下增加了时间复杂度
         */
        List<Integer> sortedList =set.stream().sorted().collect(Collectors.toList()).reversed();

        if (sortedList.size() >= 3) {
            return sortedList.get(2);
        } else {
            return sortedList.getFirst();
        }

    }
    /**
     * Comment:
     * O(n)复杂度实际上的策略是创建三个变量来同时维护最大的三个数
     */
}
