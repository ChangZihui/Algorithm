package No_1_200.No002两数相加;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("成功");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null;
        ListNode result=null;
        int a = 0;
        while (l1 != null || l2 != null || a != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+a;
            a=(sum>=10?1:0);
            ListNode listNode1 = new ListNode(sum % 10);
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            if (result==null){
                result=listNode1;
            }else {
                l.next=listNode1;
            }
            l=listNode1;
        }
        return result;
    }
}
