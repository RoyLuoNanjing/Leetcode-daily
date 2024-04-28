package leetcode.medium.Q47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Backtracking {
    /*
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
        Example 1:

        Input: nums = [1,1,2]
        Output:
        [[1,1,2],
         [1,2,1],
         [2,1,1]]
     */


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //排序

        boolean[] visited = new boolean[nums.length]; //记录是否访问过

        List<Integer> l = new ArrayList<>(); //记录临时的list

        backtracking(l, visited, nums, res);

        return res;
    }

    private void backtracking(List<Integer> l,  boolean[] visited, int[] nums, List<List<Integer>> res) {
        //如果此时，l满了则要将值添加到结果中
        if (l.size() == nums.length) {
            res.add(new ArrayList<>(l)); //必须创建新对象，不然添加的是引用
            return;
        }

        //遍历去寻找下一个点
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
                continue; // 跳过已访问的元素或相同元素的重复处理 ， 前面相同还是还有被用到，我们则要保证这种事不会发生
            }
            //此时的值加进去
            l.add(nums[i]);
            //并且标记已读
            visited[i] = true;

            backtracking(l,  visited, nums, res);
            //移除最后一位进行回溯
            l.removeLast();
            //将访问复原
            visited[i] = false;
        }
    }

}
