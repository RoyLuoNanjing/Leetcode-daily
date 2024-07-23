package hackerRank_DataStructures.Easy.BinarySearchTreeInsertion;

import hackerRank_DataStructures.classUtils.Node;

public class Solution {
    public static Node insert(Node root, int data) {
        // 如果树为空，创建一个新节点并返回
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // 否则，递归地插入数据
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        // 返回（未更改的）节点指针
        return root;
    }


}
