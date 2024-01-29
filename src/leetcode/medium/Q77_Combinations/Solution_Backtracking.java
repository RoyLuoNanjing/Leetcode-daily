package leetcode.medium.Q77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //创建一下array用于遍历
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        backtracking(array,0,k);
        return res;
    }

    private void backtracking (int[] array, int start,int k ){
        //递归结束条件放在循环开始
        if(current.size() == k){
            //通过创建 current 的一个新对象并将其添加到结果列表中，
            // 您保留了回溯算法在达到特定深度时 current 的状态。这样，
            // 即使后续对 current 进行修改（例如回溯到上一个状态并尝试其他选项）
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.length ; i++) {
            //更新状态
            current.add(array[i]);
            backtracking(array,i + 1, k);
            //回退
            current.removeLast();
        }

    }
    /**
     * Comment:
     * 很难想象它整个流程
     * 但是感觉回溯的模板还是比较确定的
     *
     */
}
