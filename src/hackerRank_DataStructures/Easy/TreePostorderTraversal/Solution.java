package hackerRank_DataStructures.Easy.TreePostorderTraversal;

import hackerRank_DataStructures.classUtils.Node;

public class Solution {
    static StringBuffer sb = new StringBuffer();

    public static void postOrder(Node root) {

        dfs(root);
        System.out.println(sb.toString());
    }

    public static void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
        sb.append(root.data + " ");
    }
}
