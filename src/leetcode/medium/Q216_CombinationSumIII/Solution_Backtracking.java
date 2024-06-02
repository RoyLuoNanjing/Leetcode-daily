package leetcode.medium.Q216_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> l = new ArrayList<>();
        backtracking(k, n, 1, 0, l);
        return res;
    }


    private void backtracking(int k, int n, int start, int total, List<Integer> l) {
        if (total == n && l.size() == k) {
            res.add(new ArrayList<>(l));
            return;
        }

        for (int i = start; i < 10; i++) {
            l.add(i);
            total += i;

            if (total > n) {
                //       total -= l.getLast();  此后都不会触发了
                l.removeLast();
                break;
            }
            backtracking(k, n, i + 1, total, l);
            total -= l.getLast();
            l.removeLast();
        }
    }
}
