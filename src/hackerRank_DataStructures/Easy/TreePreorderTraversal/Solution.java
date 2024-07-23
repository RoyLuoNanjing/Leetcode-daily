package hackerRank_DataStructures.Easy.TreePreorderTraversal;

import hackerRank_DataStructures.classUtils.Node;

public class Solution {
    static StringBuffer sb = new StringBuffer();

    public static void preOrder(Node root) {

        dfs(root);
        System.out.println(sb.toString());
    }

    public static void dfs(Node root) {
        if (root == null) return;
        sb.append(root.data + " ");
        dfs(root.left);
        dfs(root.right);
    }
}
