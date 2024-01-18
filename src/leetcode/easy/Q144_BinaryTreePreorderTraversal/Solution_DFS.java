package leetcode.easy.Q144_BinaryTreePreorderTraversal;

import leetcode.classUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    // Definition for a binary tree node.

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root,res);
        return res;
    }

    private void dfs (TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        dfs (root.left,res);
        dfs (root.right,res);
    }

    /**
     * Comment:
     * Preorder Traversal 为前序遍历，顺序为根节点 -> 左子树 ->右子树
     * 用dfs依照上述顺序将所获得的数放入arraylist里面
     * 步骤：首先递归地进行左子树的中序遍历，然后访问根节点，最后递归地进行右子树的中序遍历。
     */
}
