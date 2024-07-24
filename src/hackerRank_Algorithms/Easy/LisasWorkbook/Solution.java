package hackerRank_Algorithms.Easy.LisasWorkbook;

import java.util.List;

public class Solution {
    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int count = 0;

        int page = 0;

        for (int i = 0; i < n; i++) {
            int numOfProblems = arr.get(i);
            page++;
            int currentProblem = 0;
            while (currentProblem <= numOfProblems) {
                if (currentProblem != 0) {
                    if (currentProblem == page) {
                        count++;
                        System.out.println("currentProblem:" + currentProblem);
                        System.out.println("page:" + page);
                    }
                    if (currentProblem % k == 0 && currentProblem < numOfProblems) {
                        page++;
                    }
                }

                currentProblem++;
            }
        }
        return count;
    }
}
