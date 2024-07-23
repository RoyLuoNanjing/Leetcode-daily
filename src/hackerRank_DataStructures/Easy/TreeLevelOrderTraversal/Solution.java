package hackerRank_DataStructures.Easy.TreeLevelOrderTraversal;

import hackerRank_DataStructures.classUtils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void levelOrder(Node root) {

        if (root == null)
        {
            return;
        }

        //create a queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            //poll a node out;
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // put the left node into the queue
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // put the right node into the queue
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }
}
