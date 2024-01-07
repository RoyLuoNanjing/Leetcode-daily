package leetcode.easy.Q145_BinaryTreePostorderTraversal;

import leetcode.ClassUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    // Definition for a binary tree node.

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root,res);
        return res;
    }

    private void dfs (TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        dfs (root.left,res);
        dfs (root.right,res);
        res.add(root.val);
    }

    /**
     * Comment:
     * Preorder Traversal 为前序遍历，顺序为 左子树 -> 右子树 -> 根节点
     * 用dfs依照上述顺序将所获得的数放入arraylist里面
     * 步骤：首先递归地进行左子树的后序遍历，然后递归地进行右子树的后序遍历，最后访问根节点。
     */
}
