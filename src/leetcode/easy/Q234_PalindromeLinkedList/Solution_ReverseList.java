package leetcode.easy.Q234_PalindromeLinkedList;

import leetcode.classUtils.ListNode;

import java.util.List;

public class Solution_ReverseList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true; //链表为空则直接返回

        //找到前半部分链表的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        //反转后半部分链表，并返回后半部分的新节点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);


        //检查是否为回文
        ListNode p1 = head; //遍历前半部分
        ListNode p2 = secondHalfStart; //遍历反转后的后半部分
        boolean result = true; //初始化回文标志为true;
        //遍历翻转后的后半部分
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //恢复链表（反转后半部分，并连接），保持原始结构不变
        return result;
    }

    /**
     * 找到前半部分链表的尾节点
     *
     * @param head
     * @return
     */
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head; //快指针每次移动两步
        ListNode slow = head; //慢指针每次移动一步
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;  //慢指针指向前半部分的尾节点
    }

    /**
     * 反转链表的函数
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // 保存下一个节点
            current.next = prev; //反转当前节点的指针
            prev = current; //前一个节点向前移动
            current = nextTemp; //当前节点向前移动
        }

        return prev; //返回反转后的新头结点
    }
    /**
     * Comment:
     * 如果追求最小空间复杂度，则需要将链表分成两半，对后部分进行翻转
     * 再对两段进行遍历比较
     */

}
