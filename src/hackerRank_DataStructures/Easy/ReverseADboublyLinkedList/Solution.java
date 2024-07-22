package hackerRank_DataStructures.Easy.ReverseADboublyLinkedList;

import hackerRank_DataStructures.classUtils.DoublyLinkedListNode;

public class Solution {
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode node = null;

        while (current != null) {
            node = current.prev;
            //节点的前一个指向下一个
            current.prev = current.next;

            //节点的下一个指向原来的prev
            current.next = node;

            //节点往后移动
            current = current.prev;

        }

        if (node != null) {
            llist = node.prev;
        }
        return llist;
    }
}
