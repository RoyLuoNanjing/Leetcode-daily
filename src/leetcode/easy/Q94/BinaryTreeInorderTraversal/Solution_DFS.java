package leetcode.easy.Q94.BinaryTreeInorderTraversal;

import leetcode.classUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
     // Definition for a binary tree node.


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,ans);
        return ans;
    }

    private  void dfs (TreeNode root, List<Integer> ans){
          if (root == null){
              return;
          }
          dfs(root.left, ans);
          ans.add(root.val);
          dfs(root.right,ans);
    }

    /**
     * Comment:
     * Inorder Traversal 为中序遍历，顺序为左子树 -> 根节点 ->右子树
     * 用dfs依照上述顺序将所获得的数放入arraylist里面
     * 步骤：首先访问根节点，然后递归地进行左子树的前序遍历，最后递归地进行右子树的前序遍历。
     */
}
