package leetcode.medium.Q61_RotateList;

import leetcode.classUtils.ListNode;

public class Solution_TwoPointers {
    public ListNode rotateRight(ListNode head, int k) {
        //处理边界情况
        if (head == null || head.next == null || k <= 0) {
            return head; // 直接返回原链表
        }
        //1. 遍历获取链表长度
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head; // 形成环

        int newPosition = length - k % length;
        // 2. 找到新的头部的前一个节点并断开环
        for (int i = 0; i < newPosition; i++) {
            current = current.next;
        }
        // 设置新的头部和尾部
        ListNode newHead = current.next;
        current.next = null; // 断开环
        return newHead;
    }
    /**
     * COMMENTS:
     * 链表不是很熟练
     */
}
