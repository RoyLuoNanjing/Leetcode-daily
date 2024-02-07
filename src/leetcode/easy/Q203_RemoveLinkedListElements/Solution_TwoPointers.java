package leetcode.easy.Q203_RemoveLinkedListElements;

import leetcode.classUtils.ListNode;

public class Solution_TwoPointers {
    public ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟的头结点，就不需要单独处理删除头结点的情况
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode slow = virtualHead;
        ListNode fast = head;


        while (fast !=null){
            //如果快指针等于指定的值，则让慢指针指向快指针的下一个
            if (fast.val == val){
                slow.next = fast.next;
            }else {
                //慢指针下后走一位
                slow = slow.next;
            }
            //快指针一直正常前进
            fast = fast.next;
        }
        //返回不包含虚拟头部的链表
        return virtualHead.next;
    }
    /**
     * Comment:
     * 标准链表的题目，主要使用快慢指针
     * 满足条件就让慢指针指向快的下一个，不满足则慢指针继续往下移动
     */
}
