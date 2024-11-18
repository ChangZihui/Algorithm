package No_1001_2000.No1670设计前中后队列;

public class FrontMiddleBackQueue {

    Node head;
    Node end;
    Node mid;
    int size;

    static class Node {
        Object val;
        Node next;
        Node prev;

        Node(Object val) {
            this.val = val;
        }
    }

    public FrontMiddleBackQueue() {
        this.head = null;
        this.end = null;
        this.mid = null;
        this.size = 0;
    }

    public void pushFront(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            head = node;
            mid = node;
            end = node;
        } else {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
            if (size % 2 == 0) mid = mid.prev;
        }
        size++;
    }

    public void pushMiddle(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            head = node;
            mid = node;
            end = node;
        } else {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
            if (size % 2 == 0) mid = mid.prev;
        }
        size++;
    }

    public void pushBack(int val) {

    }

    public int popFront() {
        return 0;
    }

    public int popMiddle() {
        return 0;
    }

    public int popBack() {
        return 0;
    }

}
