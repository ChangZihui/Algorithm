package No_201_400.No234回文链表;

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