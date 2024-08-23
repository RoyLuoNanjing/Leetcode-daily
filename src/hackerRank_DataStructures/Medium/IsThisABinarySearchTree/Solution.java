package hackerRank_DataStructures.Medium.IsThisABinarySearchTree;

import hackerRank_DataStructures.classUtils.Node;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println("YeS");
            return;
        }

        Node root = new Node(scanner.nextInt());
        for (int i = 1; i < n; i++) {
            insert(root, scanner.nextInt());
        }

        boolean isBST = checkBST(root);

        if (isBST) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    private static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }
}
