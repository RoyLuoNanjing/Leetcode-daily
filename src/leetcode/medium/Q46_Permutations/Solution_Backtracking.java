package leetcode.medium.Q46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return results;
    }


    private void backtrack(int[] nums, List<Integer> current) {
        //如果已经组成了一个list则添加进结果中
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }
        //开始遍历下原数组
        for (int num : nums) {
            //如果数字用过了则跳过
            if (current.contains(num)) {
                continue;
            }
            //没有则加进去
            current.add(num);
            //继续递归下去看下后面的值还有哪些组合
            backtrack(nums, current);
            //递归到底以后，可以把上一个值通过缩小长度撤销
            current.remove(current.size() - 1);
        }
    }

    /**
     * COMMENTS:
     * 非常经典的一道回朔算法题
     * 递归到底以后一定要撤销，进而去观察其他的可能
     */
}
