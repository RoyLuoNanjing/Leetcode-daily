package leetcode.challenges.Amazon.Question1;

import java.util.Collections;
import java.util.List;

public class Solution_Brutal {
    /*
    The supply chain manager at one of amazon's warehouse is shipping the last container of the day.
    All n boxes have been loaded into the truck with their sizes represented in the array boxes .
    the truck may not have enough capacity to store all the boxes though,
    so some of the boxes may have to be unloaded.
    the remaining boxes must satisfy the condition max (boxes) <= capacity * min (boxes).
    given the array, boxes, and capacity, find the minimum number of boxes that need to be unloaded.
    example: given, n= 4, boxes having size boxes = [1,4,3,2] and capcaity = 2.
    this satisfies the required condition. hence the answer is 1.
     */
    public static int removeBoxes(List<Integer> boxes, int capacity) {
        // sort the boxes based on the size
        Collections.sort(boxes);

        int n = boxes.size();
        int minRemovals = n;  // initialize the min number of boxes being removed

        // loop the arraylist
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minBox = boxes.get(i);
                int maxBox = boxes.get(j);

                // check if it meets the condition
                if (maxBox <= capacity * minBox) {
                    int remainingBoxes = j - i + 1;
                    int removals = n - remainingBoxes; // the number of boxes that need to be removed
                    minRemovals = Math.min(minRemovals, removals);
                }
            }
        }

        return minRemovals;
    }
}
