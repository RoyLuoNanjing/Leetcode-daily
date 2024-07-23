package hackerRank_DataStructures.Easy.TreeHeightOfABinaryTree;

import hackerRank_DataStructures.classUtils.Node;

public class Solution {

    static int max = 0;
    public static int height(Node root) {
        // Write your code here.
        int current = 0;

        dfs(root, current);

        return max - 1;

    }

    public static void dfs(Node root, int current) {
        if (root == null) {
            return;
        }

        current++;
        max = Math.max(max, current);

        dfs(root.left, current );
        dfs(root.right, current);
    }

}
