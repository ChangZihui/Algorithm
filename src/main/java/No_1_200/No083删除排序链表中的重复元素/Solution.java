package No_1_200.No083删除排序链表中的重复元素;

public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        ListNode f = deleteDuplicates(null);
        while (f != null) {
            System.out.println(f.val);
            f = f.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode i = head;
        while (i != null && i.next != null) {
            if (i.val == i.next.val) {
                i.next = i.next.next;
            } else {
                i = i.next;
            }
        }
        return head;
    }
}
