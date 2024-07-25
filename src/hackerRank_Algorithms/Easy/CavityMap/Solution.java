package hackerRank_Algorithms.Easy.CavityMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        int size = grid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();


        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < grid.get(0).length() - 1; j++) {
                int top = Character.getNumericValue(grid.get(i - 1).charAt(j));
                int center = Character.getNumericValue(grid.get(i).charAt(j));
                int bottom = Character.getNumericValue(grid.get(i + 1).charAt(j));
                int left = Character.getNumericValue(grid.get(i).charAt(j - 1));
                int right = Character.getNumericValue(grid.get(i).charAt(j + 1));

                if (center > top && center > bottom && center > left && center > right) {
                    if (map.get(i) != null) {
                        map.get(i).add(j);
                    } else {
                        List<Integer> l = new ArrayList<>();
                        l.add(j);
                        map.put(i, l);
                    }
                }

            }
        }

        for (int i = 1; i < size; i++) {
            if (map.get(i)!=null){
                List<Integer> l = map.get(i);
                char[] arr = grid.get(i).toCharArray();
                for (Integer value :
                        l) {
                    arr[value] = 'X';
                }
                String s = new String(arr);
                grid.set(i, s);
            }

        }

        return grid;

    }

}
