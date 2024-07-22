package hackerRank_DataStructures.Easy.FindMergePointOfTwoLists;

import hackerRank_DataStructures.classUtils.SinglyLinkedListNode;

public class Solution {
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // 计算两个链表的长度
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // 对齐两个链表的起点
        if (length1 > length2) {
            head1 = moveForward(head1, length1 - length2);
        } else {
            head2 = moveForward(head2, length2 - length1);
        }

        // 同时遍历两个链表，找到合并点
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        // 返回合并点的值
        return head1.data;
    }

    // 获取链表的长度
    private static int getLength(SinglyLinkedListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // 将链表向前移动n个节点
    private static SinglyLinkedListNode moveForward(SinglyLinkedListNode head, int steps) {
        while (steps > 0) {
            head = head.next;
            steps--;
        }
        return head;
    }
}
