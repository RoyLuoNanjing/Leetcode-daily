package hackerRank_Algorithms.Easy.InsertionSortPart2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void insertionSort2(int n, List<Integer> arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr);

        for (int i = 1; i < n; i++) {
            int key = arrayList.get(i);
            int j = i - 1;

            while (j >= 0 && arrayList.get(j) > key) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }

            arrayList.set(j + 1, key);
            printArray(arrayList);
        }
    }

    private static void printArray(ArrayList<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
