package leetcode.easy.Q349_IntersectionOfTwoArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_HashSet {
    public int[] intersection(int[] nums1, int[] nums2) {
        //创造一个记录结果的容器
        List<Integer> list = new ArrayList<>();

        //记录第一个array的值
        HashSet set = new HashSet();
        //记录第二个array的值
        HashSet set2 = new HashSet();

        //遍历第一个array
        for (int num : nums1) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        //遍历第二个array
        for (int num : nums2) {
            if (set.contains(num) && !set2.contains(num)) {
                list.add(num);
                set2.add(num);
            }
        }

        //将list转化为array
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * Comment:
     * Easy
     */
}
