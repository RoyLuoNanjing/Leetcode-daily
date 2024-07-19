package hackerRank_DataStructures.Easy.InsertANodeAtASpecficPositionInALinkedList;

import java.io.BufferedWriter;
import java.io.IOException;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
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

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here

        SinglyLinkedListNode d = new SinglyLinkedListNode(data);

        SinglyLinkedListNode ref = llist;
        if (position == 0) {
            d.next = llist;
            return d;
        }

        int count = 0;

        while (count + 1 != position) {
            llist = llist.next;
            count++;
        }
        d.next = llist.next;

        llist.next = d;

        return ref;
    }
}
