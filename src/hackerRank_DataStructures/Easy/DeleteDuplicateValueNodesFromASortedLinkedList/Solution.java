package hackerRank_DataStructures.Easy.DeleteDuplicateValueNodesFromASortedLinkedList;

import hackerRank_DataStructures.classUtils.SinglyLinkedListNode;

public class Solution {
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode head = llist;

        while (llist.next != null) {
            if (llist.data == llist.next.data) {
                if (llist.next.next == null) {
                    llist.next = null;
                    break;
                }
                llist.next = llist.next.next;
                    continue;
            }
            llist = llist.next;
        }
        return head;
    }
}
