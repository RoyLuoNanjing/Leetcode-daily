package hackerRank_Algorithms.Easy.TwoCharacters;

import java.util.*;

public class Solution {

    public static int alternate(String s) {
        int maxLength = 0;
        // Write your code here
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        List<Character> list = new ArrayList<>(map.keySet());


        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isAlternate(s, list.get(i), list.get(j))) {
                    int aLength = map.get(list.get(i));
                    int bLength = map.get(list.get(j));
                    maxLength = Math.max(maxLength, aLength + bLength);
                }
            }
        }

        return maxLength;
    }

    private static boolean isAlternate(String s, char a, char b) {
        boolean isAlternate = true;
        char flag1 = a; // first
        char flag2 = b; // second
        //find the first
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                flag1 = b;
                flag2 = a;
                break;
            } else if (s.charAt(i) == b) {
                flag1 = a;
                flag2 = b;
                break;
            }
        }


        for (int i = 0; i < s.length(); i++) {
            //ignore
            if (s.charAt(i) != flag1 && s.charAt(i) != flag2) {
                continue;
            }
            // not alternate
            if (s.charAt(i) == flag1) {
                isAlternate = false;
                break;
            }
            //switch
            if (s.charAt(i) == flag2) {
                char temp = flag1;
                flag1 = flag2;
                flag2 = temp;
            }
        }
        return isAlternate;
    }
}
