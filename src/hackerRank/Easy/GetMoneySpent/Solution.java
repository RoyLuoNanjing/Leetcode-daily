package hackerRank.Easy.GetMoneySpent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */


        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int cost =keyboards[i] + drives[j];
                if (cost <= b){
                    list.add(cost);
                }
            }
        }

        if (list.isEmpty()) {
            return -1;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);

    }


}

