package hackerRank_DataStructures.Easy.InsertANodeAtTheTailOfALinkedList;

public class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public SinglyLinkedListNode(int data) {
        this(data, null); // 初始化时 next 默认为 null
    }
}
