package No_201_400.No234回文链表;

import java.util.Stack;

public class MySolution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (stack.isEmpty()) return false;
            if (p.val != stack.pop()) return false;
            p = p.next;
        }
        return true;
    }

}
