package No_1_200.No138随机链表的复制;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return val
                + "||next:" + (next == null ? "null" : next.val)
                + "||random:" + (random == null ? "null" : random.val);
    }
}
