package hackerRank.Easy.PermutationEquation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < p.size(); i++) {
            map.put(p.get(i), i);
        }

        /**
         *  1 : 2
         *  2:  1
         *  3:  3
         *  4:  4
         *  5:  0
         * */

        for (int i = 1; i <= p.size(); i++) {
            int first = map.get(i) + 1;
            int second = map.get(first) ;
            list.add(second + 1);

        }

        return list;
    }
}
