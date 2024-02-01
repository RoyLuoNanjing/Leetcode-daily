package leetcode.easy.Q169_MajorityElement;

public class Solution_BoyerMooreVotingAlgorithm {
    public int majorityElement(int[] nums) {
        int candidate = 0; // 候选元素
        int count = 0; // 候选元素出现次数

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // 更新候选元素
                count = 1;
            } else if (num == candidate) {
                count++; // 候选元素出现，增加计数
            } else {
                count--; //候选元素未出现，减少计数
            }
        }
        return candidate; //最后候选元素就是出现次数超过一半的元素
    }
    /**
     * Comment:
     * 摩尔算法很巧妙
     * 但是也要注意这题的条件，答案一定有众数
     */
}
