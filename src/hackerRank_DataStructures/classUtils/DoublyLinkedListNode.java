package hackerRank_DataStructures.classUtils;

public  class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data, DoublyLinkedListNode next,DoublyLinkedListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedListNode(int data) {
        this(data, null,null); // 初始化时 next 默认为 null
    }
}
