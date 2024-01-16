package leetcode.easy.Q2744_FindMaximumNumberOfStringPairs;

import java.util.HashMap;

public class Solution_HashMap {
    public int maximumNumberOfStringPairs(String[] words) {
        HashMap<String,String> map = new HashMap<>();
        int count = 0;
        for(String word : words){
            String sb = new StringBuffer(word).reverse().toString();
            String s = map.get(sb);

            if (s == null){
                map.put(word,sb);
            }else {
                count++;
            }
        }
        return count;
    }
    /**
     * Comment:
     * 利用buffer来倒置，再利用hashmap
     */
}
