package leetcode.medium.Q82_RemoveDuplicatesFromSortedListII;

import leetcode.classUtils.ListNode;

public class Solution_TwoPointers {
    public ListNode deleteDuplicates(ListNode head) {
        //检查是不是为空
        if (head == null) {
            return null;
        }

        ListNode anchor = new ListNode(0); //创建一个新的链表表头
        ListNode pointerAtAnchor = anchor;
        ListNode current = head;


        while (current != null) {
            //检查当前节点是否有重复，要保证下一个要存在
            if (current.next != null && current.val == current.next.val) {
                //需要一直跳过直到没有重复的
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
            } else {
                //没有重复节点就将节点加入到新链表
                pointerAtAnchor.next = new ListNode(current.val);
                pointerAtAnchor = pointerAtAnchor.next;
            }

            current = current.next;
        }

        return anchor.next;
    }

    /**
     * Comment:
     * 思路还是有的，可以创建一个新的链表把数据放进去，用指针一直检索
     */
}
