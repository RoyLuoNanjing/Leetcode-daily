package hackerRank_Algorithms.Medium.LilysHomework;

import java.util.*;

public class Solution {

    public static int lilysHomework(List<Integer> arr) {
        return Math.min(minSwapsToSort(arr, true), minSwapsToSort(arr, false));
    }

    private static int minSwapsToSort(List<Integer> arr, boolean ascending) {
        int n = arr.size();

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr.get(i), i);
        }

        List<Integer> sortedArr = new ArrayList<>(arr);
        if (ascending) {
            Collections.sort(sortedArr);
        } else {
            sortedArr.sort(Collections.reverseOrder());
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(sortedArr.get(i)) == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;

                j = indexMap.get(sortedArr.get(j));
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}
