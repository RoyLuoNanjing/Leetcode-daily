package hackerRank_Algorithms.Easy.InsertionSortPart1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void insertionSort1(int n, List<Integer> arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr);

        int key = arrayList.get(n - 1);
        int i = n - 2;


        while (i >= 0 && arrayList.get(i) > key) {
            arrayList.set(i + 1, arrayList.get(i));
            printArray(arrayList);
            i--;
        }


        arrayList.set(i + 1, key);
        printArray(arrayList);
    }

    private static void printArray(ArrayList<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
