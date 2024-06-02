package leetcode.medium.Q86_PartitionList;

import leetcode.classUtils.ListNode;

import java.util.List;

public class Solution_TwoPointers {
    public ListNode partition(ListNode head, int x) {
        //创建一个新的链表存取大于x的node
        ListNode large = new ListNode(0);
        //创建一个新的链表存取小于x的node
        ListNode small = new ListNode(0);
        //记录旧链表的头，防止丢失
        ListNode head1 = large;
        //记录新链表的头，防止丢失
        ListNode head2 = small;

        //遍历
        while (head!= null) {
            //如果下一个的值大于x
            if (head.val >= x) {
                large.next = head;
                large = large.next;
            }else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        //避免环形链表
        large.next = null;
        //将第一个链表的尾部和第二个链表头部相连
        small.next = head1.next;

        //返回第一个链表的头部
        return head2.next;
    }


    /**
     * Comment:
     * 标准链表的双指针做法
     * 链表一定要记着记录头部
     * 此外，这种两条新链表在一条旧链表上穿插的情况，要考虑最后的环形问题
     */
}
