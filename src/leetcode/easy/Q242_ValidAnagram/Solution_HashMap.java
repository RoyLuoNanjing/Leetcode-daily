package leetcode.easy.Q242_ValidAnagram;

import java.util.HashMap;

public class Solution_HashMap {
    /*
    Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
     */
    public boolean isAnagram(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        if (sL != tL ) return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //check if the char is saved
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),1) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),1) + 1);
        }

        return sMap.equals(tMap);
    }

    /**
     * Comment:
     * 两个hashmap直接记录Char和其对应数量
     */
}
