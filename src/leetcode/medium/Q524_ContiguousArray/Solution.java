package leetcode.medium.Q524_ContiguousArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        //使用哈希表来存储每个累积和第一次出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        //初始化，用来处理累积和为0的情况，意味着从数组开始到当前索引的子数组0和1的数量相等
        map.put(0, -1);
        //用于存储最长的长度
        int maxLength = 0;
        //累积和变量，开始为0
        int count = 0;

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //更新累积和，将0视为-1,1视为1
            count += (nums[i] == 1 ? 1 : -1);

            //如果当前累积和之前出现过，我们找到了一个从之前索引+1到当前索引的子数组，其0和1的数量相等
            if(map.containsKey(count)){
                //计算这个子数组的长度，并更新最大长度
                maxLength = Math.max(maxLength, i - map.get(count));
            }else {
                //如果这是第一次遇到这个累积和，记录它的索引
                map.put(count , i);
            }
        }

        //返回找到的最长长度
        return maxLength;
    }
    /**
     * Comment:
     * 比较巧妙的思路，将数组中的0全部替换-1，然后计算累积和（前缀和）
     * 然后用HashMap来记录第一次出现-1,0,1这三种前缀和的情况的索引
     * 然后遍历计算相同前缀和之间的长度
     * 因为每个相同的前缀和之间的数组一定是0和 1相等的
     */

}
