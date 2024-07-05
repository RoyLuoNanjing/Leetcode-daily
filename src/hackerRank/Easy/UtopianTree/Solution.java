package hackerRank.Easy.UtopianTree;

public class Solution {
    public static int utopianTree(int n) {
        // Write your code here
        boolean isSpring = true;
        int tree = 1;
        for (int i = 1; i <= n; i++) {
            if (isSpring) {
                tree = tree * 2;
                isSpring = false;
            } else {
                tree++;
                isSpring = true;
            }
        }

        return tree;
    }

    public static void main(String[] args) {
        utopianTree(2);
    }
}
