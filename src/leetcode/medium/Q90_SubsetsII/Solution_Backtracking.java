package leetcode.medium.Q90_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Backtracking {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序一下数组
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        backtracking(nums, 0, current);
        return res;
    }



    public void backtracking(int[] nums, int start, List<Integer> current) {
        res.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            // 如果当前元素和前一个元素相同，且不是第一个元素，则跳过以避免重复子集
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtracking(nums, i + 1, current);
            current.removeLast();
        }
    }

    /**
     * Comment:
     * 标准的回溯题
     * 关键点在于循环内和之前的数比较进行去重
     */
}
