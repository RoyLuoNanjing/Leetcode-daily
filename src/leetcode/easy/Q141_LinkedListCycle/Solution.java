package leetcode.easy.Q141_LinkedListCycle;

import leetcode.classUtils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        //存储访问过的Node而不是val
        Set<ListNode> set = new HashSet<>();
        while (head.next != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
    /**
     * Comment:
     * 第一次犯错的原因主要是默认了val是唯一的
     * 主要还是通过set来存node对象
     * 如果想要空间复杂度为1的话，可以使用快慢指针，一个每次都异步，另一个每次走两步
     * 如果循环的话，两个指正最后一定会走在一起
     */
}
