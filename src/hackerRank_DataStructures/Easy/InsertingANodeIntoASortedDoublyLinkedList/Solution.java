package hackerRank_DataStructures.Easy.InsertingANodeIntoASortedDoublyLinkedList;

import hackerRank_DataStructures.classUtils.DoublyLinkedListNode;

public class Solution {
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        // If the list is empty
        if (llist == null) {
            return newNode;
        }

        DoublyLinkedListNode current = llist;

        // If the new node should be inserted at the beginning
        if (data <= current.data) {
            newNode.next = current;
            current.prev = newNode;
            return newNode;
        }

        // Traverse the list to find the insertion point
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        // Insert the new node in the middle or at the end
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        return llist;
    }
}
