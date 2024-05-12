package leetcode.medium.Q92_ReverseLinkedListII;

import leetcode.classUtils.ListNode;

import java.util.ArrayList;

public class Solution_LinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        //创建一个虚拟的头节点，简化操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //找到left前面的节点 prePartTail
        ListNode prePartTail  = dummy;
        for (int i = 0; i < left - 1; i++) {
            prePartTail = prePartTail.next;
        }

        //初始化三指针法中的前，当前，后节点
        ListNode current = prePartTail.next;
        ListNode prev = null;
        ListNode next = null;

        //进行链表部分的反转
        for (int i = 0; i < right - left + 1; i++) {
            next = current.next; // 先保存一下当前的节点
            current.next = prev; //下一个指向前面的一个， 第一次永远为空
            prev = current; //把前一个节点存下来
            current = next; //移动到下一个节点
        }

        //将反转后的部分连接回原链表
        prePartTail.next.next = current;
        prePartTail.next = prev;

        //返回虚拟节点的下一个节点
        return dummy.next;
    }
}
