package leetcode.medium.Q78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return output;
    }

    private void backtrack(int start, int[] nums, List<Integer> current) {
        output.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            // 加入当前元素
            current.add(nums[i]);
            // 递归剩余元素
            backtrack(i + 1, nums, current);
            // 移除当前元素，回溯
            current.remove(current.size() - 1);
        }
    }

    /**
     * Comment:
     * 有点难，特别是回溯的顺序还没有搞懂
     *
     */
}

