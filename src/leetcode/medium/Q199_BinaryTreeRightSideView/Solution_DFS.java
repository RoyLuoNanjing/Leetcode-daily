package leetcode.medium.Q199_BinaryTreeRightSideView;

import leetcode.classUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {

    List<Integer> res = new ArrayList<>();
    int depth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;


        //只在每次达到这个深度的时候记录值，从而保证每一个层级只有最先遍历到的（即右边的）被记录
        if (res.size() == depth){
            res.add(root.val);
        }

        depth++;
        dfs(root.right);
        dfs(root.left);
        //要从头到尾记录遍历深度，如果返回上一层则-1
        depth--;
    }
    /**
     * COMMENTS:
     * 此题技巧是遍历用根-右-左
     * 实现方式不是通过跳过左节点来获得答案
     * 思路是保证每一个层级只记录遍历到的第一个值，因为遍历顺序，我们一定第一个遍历的是右边的值
     * 可以通过对比list的大小和层级来决定是否记录这个值，如果刚到新的一层则记录
     * 记住一定有一个全局变量记录深度，下一层+1，返回上一层-1
     */

}
