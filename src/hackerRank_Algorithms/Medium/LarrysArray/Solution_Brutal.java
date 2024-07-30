package hackerRank_Algorithms.Medium.LarrysArray;

import java.util.List;

public class Solution_Brutal {
    public static String larrysArray(List<Integer> A) {
        // Write your code here
        int l = A.size();

        int[] array = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            array[i] = A.get(i);
        }

        int first = 0;
        int second = 0;
        int third = 0;

        int start = 0;
        boolean isLastConsidered = false;
        while (start < l - 1) {
            for (int i = start; i < l - 2; i++) {
                first = array[i];
                second = array[i + 1];
                third = array[i + 2];
                // first is the smallest, we don't do anything
                if (first < second && first < third) {
                    continue;
                }
                //second is the smallest
                if (second < first && second < third) {
                    array[i] = second;
                    array[i + 1] = third;
                    array[i + 2] = first;
                    break;
                }
                // third is the smallest
                if (third < first && third < second) {
                    array[i] = third;
                    array[i + 1] = first;
                    array[i + 2] = second;
                    break;
                }

            }
            start = sortedToIndex(array);
            if (start == l - 3){
                isLastConsidered = true;
            }

            if (start == l - 3 && isLastConsidered){
                break;
            }
        }
        int finalRes = sortedToIndex(array);
        if (finalRes == l - 1) {
            return "YES";

        }
        return "NO";


    }

    private static int sortedToIndex(int[] arr) {
        int l = arr.length;
        int point = l - 1;
        for (int i = 1; i < l; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                point = i - 1;
                break;
            }
        }
        return point;
    }
}




