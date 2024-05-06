package leetcode.easy.Q283_MoveZeros;

public class Solution_TwoPointers {
    public void moveZeroes(int[] nums) {
        int noZeroIndex = 0;
        //将数组内不为0的数从前开始往后排
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[noZeroIndex] = nums[i];
                noZeroIndex++;
            }
        }
        //把剩余的数全部变成0；
        for (int i = noZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
