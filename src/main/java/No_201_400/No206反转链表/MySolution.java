package No_201_400.No206反转链表;

public class MySolution {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode vHead = new ListNode(0, head);
        while (head.next != null) {
            ListNode toMove = head.next;
            head.next = toMove.next;
            ListNode lastHead = vHead.next;
            vHead.next = toMove;
            toMove.next = lastHead;
        }
        return vHead.next;
    }

}
