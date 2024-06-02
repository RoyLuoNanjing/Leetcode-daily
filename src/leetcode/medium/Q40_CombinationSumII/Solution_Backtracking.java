package leetcode.medium.Q40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Backtracking {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
        Example 1:

        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
     */


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList<>();
        backtracking(candidates, target, 0, 0, l, res);

        return res;
    }


    private void backtracking(int[] candidates, int target, int start, int total, List<Integer> l, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(l));
           return;
        }

        for (int i = start; i < candidates.length; i++) {
            //避免重复的情况，我此时选的数不能和之前的一样
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            total += candidates[i];
            l.add(candidates[i]);

            //如果大于target则后面都没有必要看了
            if (total > target) {
                l.removeLast();
                break;
            };

            backtracking(candidates, target, i + 1, total, l, res);
            total -= l.getLast();
            l.removeLast();
        }
    }
}
