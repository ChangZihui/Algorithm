package No_1_200.No021合并两个有序链表;

public class Solution {
    public static void main(String[] args) {
        ListNode a =new ListNode(1);
        a.next=new ListNode(3);
        ListNode b=new ListNode(0);
        b.next=new ListNode(4);
        ListNode c=mergeTwoLists2(a ,b);
        while (c!=null){
            System.out.println(c.val);
            c=c.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result;
        ListNode i;
        ListNode j;
        if (list1.val < list2.val) {
            result = list1;
            i = list1.next;
            j = list2;
        } else {
            result = list2;
            i = list1;
            j = list2.next;
        }
        ListNode k = result;
        while (i!= null && j != null) {
            if (i.val <= j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }
        if (i==null){
            k.next=j;
        }
        if (j==null){
            k.next=i;
        }
        return result;
    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
