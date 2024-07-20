package hackerRank_DataStructures.Easy.GetNodeValue;

public class Solution {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode head = llist;

        int count = 0;
        while (llist != null) {
            count++;
            llist = llist.next;
        }

        int positionFromHead = count - positionFromTail - 1;

        int index = 0;

        while (index != positionFromHead) {
            index++;
            head = head.next;
        }

        return head.data;

    }
}
