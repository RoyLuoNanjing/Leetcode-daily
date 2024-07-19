package hackerRank_DataStructures.Easy.LeftRotation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();

        int l = arr.size();

        for (int i = 0; i < l; i++) {
            int value = arr.get((i + d) % l);
            res.add(value);
        }
        return res;
    }
}
