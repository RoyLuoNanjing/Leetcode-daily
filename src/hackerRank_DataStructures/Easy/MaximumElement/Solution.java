package hackerRank_DataStructures.Easy.MaximumElement;

import java.util.*;

public class Solution {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        List<Integer> res = new ArrayList<>();
        for (String s :
                operations) {
            String[] sArr = s.split(" ");
            switch (sArr[0]) {
                case "1" -> {
                    int current = (Integer.parseInt(sArr[1]));
                    treeMap.put(current, treeMap.getOrDefault(current, 0) + 1);
                    stack.push(current);
                }
                case "2" -> {
                    if (!stack.isEmpty()) {
                        int removedInt = stack.peek();
                        int numberOfRemovedInt = treeMap.get(removedInt);

                        if (numberOfRemovedInt == 1) {
                            treeMap.remove(removedInt);
                        } else {
                            treeMap.put(removedInt, treeMap.get(removedInt) - 1);
                        }
                        stack.pop();
                    }
                }
                default -> {
                    res.add(treeMap.lastKey());
                }
            }
        }

        return res;
    }
}
