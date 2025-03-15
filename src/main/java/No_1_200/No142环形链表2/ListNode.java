package No_1_200.No142环形链表2;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    private static int[] ints = new int[1024];

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}