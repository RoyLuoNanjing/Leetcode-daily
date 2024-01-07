package leetcode.easy.Q94.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;     }
      }

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
     */
}
