package hackerRank.Easy.SockMerchant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = ar.get(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        for (Integer value : map.values()){
            count += value / 2;

        }


        return count;

    }

    public static void main(String[] args) {
        int n = 9;
        List ar = new ArrayList<>(Arrays.asList(10,20,20,10,10,30,50,10,20));

        sockMerchant(n,ar);
    }
}



