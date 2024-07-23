package hackerRank_DataStructures.Easy.TreeInorderTraversal;

import hackerRank_DataStructures.classUtils.Node;

public class Solution {
    static StringBuffer sb = new StringBuffer();

    public static void inOrder(Node root) {

        dfs(root);
        System.out.println(sb.toString());
    }

    public static void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);
        sb.append(root.data + " ");
        dfs(root.right);

    }
}
