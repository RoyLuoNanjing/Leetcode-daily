package leetcode.medium.Q797_AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        l.add(0); //初始化
        backtracking(0, n, graph, l, res);
        return res;
    }

    private void backtracking(int node, int n, int[][] graph, List<Integer> l, List<List<Integer>> res) {
        //如果找到了n - 1
        if (node == n - 1) {
            res.add(new ArrayList<>(l));
            return;
        }

        //找到此时节点所连接的数的array
        int[] arr = graph[node];
        //对其进行遍历
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
            backtracking(arr[i], n, graph, l, res);
            l.removeLast();
        }
    }

    /**
     * Comment:
     * 回溯， 套模版，一次过
     */
}
