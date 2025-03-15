package No_1_200.No19删除链表的倒数第N个结点;

public class MySolution {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode vhead = new ListNode(0, head);
        ListNode p1 = head;
        ListNode p2 = vhead;
        int interval = 1;
        while (p1.next != null) {
            p1 = p1.next;
            if (interval == n) {
                p2 = p2.next;
            } else {
                interval++;
            }
        }
        p2.next = p2.next.next;
        return vhead.next;
    }
}
