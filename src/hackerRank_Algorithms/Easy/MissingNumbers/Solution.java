package hackerRank_Algorithms.Easy.MissingNumbers;

import java.util.*;

public class Solution {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Map<Integer, Integer> originMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> resSet = new TreeSet<>();


        for (int num : brr
        ) {
            originMap.put(num, originMap.getOrDefault(num, 0) + 1);
        }


        for (int num : arr
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : originMap.keySet()
        ) {
            if (!map.containsKey(key)) {
                resSet.add(key);
            }

            if (!Objects.equals(map.get(key), originMap.get(key))) {
                resSet.add(key);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int num : resSet
        ) {
            res.add(num);
        }

        return res;
    }
}
