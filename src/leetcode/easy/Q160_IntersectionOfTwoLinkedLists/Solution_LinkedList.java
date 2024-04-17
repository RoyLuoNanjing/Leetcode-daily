package leetcode.easy.Q160_IntersectionOfTwoLinkedLists;

import leetcode.classUtils.ListNode;

public class Solution_LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        //调整较长的链表的起点
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        //起点相同时，开始比较此时的地址是否相同
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        //最后只需要去A或B的任意一个Node,有值就是发现了，没值就是null
        return headA;
    }


    public int getLength(ListNode head) {
        int count = 0;
        //保护头节点
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    /**
     * Comment:
     * 比较巧妙的写法
     * 如果两个相交，则相交点以后得长度一定相等
     * 所以先比较两个长度，然后遍历拉齐到统一长度
     * 再一个一个比较node的内存地址
     */
}
