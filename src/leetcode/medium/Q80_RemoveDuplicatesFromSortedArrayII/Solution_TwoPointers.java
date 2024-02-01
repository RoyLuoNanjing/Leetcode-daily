package leetcode.medium.Q80_RemoveDuplicatesFromSortedArrayII;

public class Solution_TwoPointers {
    public int removeDuplicates(int[] nums) {

        if (nums.length <=2){
            return nums.length;
        }
        int pointer = 2; //从第三个元素开始，因为前两个允许重复
        for (int i = 2; i < nums.length; i++) {
            //如果与前两个不一样,注意此时观察的应该是pointer对应的数组
            //如果此时的值与pointer前两位的不一样则可以进行覆盖并且移动指针
            if(nums[i] != nums[pointer-2] ){
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }
    /**
     * Comment:
     * 条件选择上有点难度
     * 主要是双指针方法，pointer由于生成第二个数组
     * 判断条件是第二个指针往前两位是否一样，如果一样则把指针放在这里，等待下一个循环来覆盖
     *
     */
}
