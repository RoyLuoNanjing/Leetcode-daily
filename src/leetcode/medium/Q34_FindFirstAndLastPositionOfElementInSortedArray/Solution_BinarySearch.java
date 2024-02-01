package leetcode.medium.Q34_FindFirstAndLastPositionOfElementInSortedArray;

public class Solution_BinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //初始化一个array容器用于存储答案
        int[] output = new int[2];
        //调用二分查找先找到该数的大致位置
        int res = binarySearch(nums, left, right, target);
        //如果找不到则返回默认值
        if (res == -1) {
            output[0] = -1;
            output[1] = -1;
        }
        //找到了，则需要向前和向后去找下整个target的区间，这里实际上会有时间复杂度升高的情况
        else {
            // 向左推导左边界
            int leftBound = res;
            while (leftBound > 0 && nums[leftBound - 1] == target) {
                leftBound--;
            }

            // 向右推导右边界
            int rightBound = res;
            while (rightBound < nums.length - 1 && nums[rightBound + 1] == target) {
                rightBound++;
            }

            output[0] = leftBound;
            output[1] = rightBound;
        }
        return output;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        //如果没找到则返回-1
        if (left > right) return -1;
        //这种找中间数的写法可以保证int不会溢出
        int mid = (right - left) / 2 + left;

        if (nums[mid] > target) {
            right = mid - 1;
            return binarySearch(nums, left, right, target); //递归时记得return
        } else if (nums[mid] < target) {
            left = mid + 1;
            return binarySearch(nums, left, right, target);
        } else {
            return mid;
        }
    }

    /**
     * COMMENTS:
     * 二分查找还需要再熟练一点
     * 此写法在极端条件下达不到要求的时间复杂度
     * 但是leetcode提交以后显示还是高效的
     */
}
