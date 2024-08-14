package leetcode.medium.Q3152_SpecialArrayII;

import java.util.Arrays;

public class Solution_Brutal {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int resLength = queries.length;

        boolean[] res = new boolean[resLength];

        for (int i = 0; i < resLength; i++) {
            int[] ref = queries[i];
            int[] subArray = Arrays.copyOfRange(nums, ref[0], ref[1] + 1);
            String s = subArray.toString();
            System.out.println(s);
            res[i] = isArraySpecial(subArray);
        }

        return res;

    }

    private static boolean isArraySpecial(int[] nums) {
        int length = nums.length;

        if (length <= 1) return true;

        boolean ans = true;

        for (int i = 1; i < length; i++) {
            int ref = (nums[i - 1] + nums[i]) % 2;
            if (ref != 1) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
