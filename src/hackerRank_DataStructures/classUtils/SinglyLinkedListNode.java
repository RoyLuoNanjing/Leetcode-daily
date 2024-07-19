package hackerRank_DataStructures.classUtils;

public class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public SinglyLinkedListNode(int data) {
        this(data, null); // 初始化时 next 默认为 null
    }
}
