package leetcode.medium.Q2807_InsertGreatestCommonDivisorsInLinkedList;

import leetcode.classUtils.ListNode;

public class Solution_Math_EuclideanAlgorithm {
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode headMark = head;

        while (head.next != null){
            int newNodeValue = getGreastestCommonDivisors(head.val, head.next.val);
            ListNode gcdNode = new ListNode(newNodeValue);
            gcdNode.next = head.next;
            head.next = gcdNode;
            head = gcdNode.next;
        }
        return headMark;
    }

    /**
     * 在Java中，计算两个数的最大公约数（GCD，Greatest Common Divisor）通常可以使用辗转相除法（也叫欧几里得算法）。
     * 这种方法基于一个重要的数学定理：两个整数的最大公约数与它们的差的最大公约数相同
     * @param a
     * @param b
     * @return
     */
    private static int getGreastestCommonDivisors (int a , int b){
        while (b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Comment:
     * 这题关键点在于如何创造一个函数来计算出每次的最大公约数
     * 此处用的是欧几里何算法，感觉想不到哦
     * 对于链表来说操作就是典型的插入方法
     *
     */
}
