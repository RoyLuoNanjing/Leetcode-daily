package leetcode.easy.Q3151_SpecialArrayI;

public class Solution {
    public boolean isArraySpecial(int[] nums) {
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
