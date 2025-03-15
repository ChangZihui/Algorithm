package No_1_200.No160相交链表;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)) return headB;
            set.add(headB);
            headB=headB.next;
        }
        return null;
    }
}
