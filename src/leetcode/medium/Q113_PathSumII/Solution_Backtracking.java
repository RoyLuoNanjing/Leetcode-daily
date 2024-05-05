package leetcode.medium.Q113_PathSumII;

import leetcode.classUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        backtracking(res, l, root, 0, targetSum);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> l, TreeNode root, int sum, int targetSum) {
        //如果不存在就return
        if (root == null) return;
        //添加值

        sum += root.val;

        //剪枝  （还是不要剪枝，因为这边有负数的）
//        if (sum > targetSum) {
//            return;
//        }
        l.add(root.val);


        //如果满足root-to-leaf 则 添加该l
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(l));
            l.removeLast();  //找到以后要把最后一个给移除掉
            return;
        }

        backtracking(res, l, root.left, sum, targetSum);
        backtracking(res, l, root.right, sum, targetSum);
        //回滚
        l.removeLast();

    }

    /**
     * Comment:
     * 标准的回溯
     */
}
