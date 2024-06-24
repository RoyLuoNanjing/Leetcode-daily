package hackerRank.Easy.CircularArrayRotation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        int l = a.size();
        k = k % l;

        List<Integer> list = new ArrayList<>();

/**  这一步没有考虑如果是反方向的旋转的情况*/
//        int start = l - k;
//        while (list.size() < l) {
//            int current = a.get(start);
//            list.add(current);
//            start = (start + 1) % l;
//        }

        for (int i = 0; i < l; i++) {
            // 计算旋转后元素的位置
            list.add(a.get((l - k + i) % l));
        }


        List<Integer> res = new ArrayList<>();

        for (Integer number : queries) {
            res.add(list.get(number));
        }

        return res;

    }

}
