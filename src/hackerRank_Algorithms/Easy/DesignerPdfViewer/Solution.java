package hackerRank_Algorithms.Easy.DesignerPdfViewer;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            int current =  h.get(word.charAt(i) - 97);
            map.put(word.charAt(i),current);
        }

        int height = 1;
        for(Integer value : map.values()){
            height = Math.max(value,height);
        }


        return word.length() * height;
    }

}
