package No_1_200.No142环形链表2;

import java.util.HashSet;
import java.util.Set;

public class MySolution {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            else set.add(head);
            head = head.next;
        }
        return null;
    }
}
