package hackerRank.Easy.BonAppetit;

import java.util.List;

public class Solution {
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        int totalShared = 0;

        for (int i = 0; i < bill.size(); i++) {
            if (i == k) continue;

            totalShared += bill.get(i);
        }

        int split = totalShared / 2;

        if (split == b){
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - split);
        }
    }
}
