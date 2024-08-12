package leetcode.challenges.Amazon.Question1;

import java.util.Collections;
import java.util.List;

public class Solution_SlidingWindow {
    public static int removeBoxes(List<Integer> boxes, int capacity) {
        Collections.sort(boxes);

        int n = boxes.size();
        int minRemovals = n;  // initialization

        int left = 0;

        // Sliding window
        for (int right = 0; right < n; right++) {
            // check if it meets the condition
            while (boxes.get(right) > capacity * boxes.get(left)) {
                left++;
            }
            // update the minimum removal number
            int removals = n - (right - left + 1);
            minRemovals = Math.min(minRemovals, removals);
        }

        return minRemovals;
    }
}
