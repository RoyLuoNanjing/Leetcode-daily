package leetcode.medium.Q75_SortColors;

public class Solution_TwoPointers {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int pointerHead = 0;
        int pointerTail = length - 1;

        for (int i = 0; i <= pointerTail; i++) {

            while (i < pointerTail && nums[i] == 2) {
                nums[i] = nums[pointerTail];
                nums[pointerTail] = 2;
                pointerTail--;
            }
            if (nums[i] == 0) {
                nums[i] = nums[pointerHead];
                nums[pointerHead] = 0;
                pointerHead++;
            }
        }

    }
}
