package hackerRank_Algorithms.Easy.SaveThePrisoner;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        m = m % n;
        int start = 1;
        boolean isStart = false;
        while (start < m) {
            if (queue.peek() == s) {
                isStart = true;
            }
            int head = queue.poll();
            queue.add(head);
            if (isStart) {
                start++;
            }

        }


        return queue.peek();
    }

    /**
     * 这个方法用了队列，但是还是超时了
     */
}
