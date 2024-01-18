package leetcode.easy.Q83_RemoveDuplicatesFromSortedList;

import leetcode.classUtils.ListNode;

public class Solution_LinkedList {


    public ListNode deleteDuplicates(ListNode head) {
        //检查是不是空的
        if (head == null || head.next == null){
            return head;
        }
        //有一个临时的Node来遍历
        ListNode current = head;
        //节点最后两个不能为空
        while (current!=null && current.next !=null){
            //如果此时的和下一个值一样，则让下一个节点变成下下个
            if (current.val == current.next.val){
                current.next = current.next.next;

            } else {
                //不然就继续遍历到下一个节点
                current = current.next;
            }
        }
        return head;
    }

    /**
     * Comment:
     * 主要还是对linkedlist的运用
     */
}
