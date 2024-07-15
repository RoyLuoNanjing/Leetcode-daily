package hackerRank.Easy.CutTheSticks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        int l = arr.size();

        List<Integer> res = new ArrayList<>();

        boolean stop = true;


        while (stop) {
            int min = Integer.MAX_VALUE;
            int count = 0;
            int total = 0;
            for (int i = 0; i < l; i++) {
                //filter values smaller than 0
                if (arr.get(i) <= 0) continue;
                //find the min value
                min = Math.min(arr.get(i), min);
            }

            for (int i = 0; i < l; i++) {
                //filter values smaller than 0
                if (arr.get(i) <= 0) continue;
                //deduct the min values
                int value = arr.get(i) - min;
                arr.set(i, Math.max(value, 0));
                count++;
                total += value;

            }
            res.add(count);

            if (total <= 0) {
                stop = false;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1));

        cutTheSticks(arr);


    }
}
