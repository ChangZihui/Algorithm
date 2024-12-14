package No_1_200.No24反转链表;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseList(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        while (head!=null){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
