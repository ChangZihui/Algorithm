package No_2501_3000.No2807在链表中插入最大公约数;

public class Solution {
    public static void main(String[] args) {
        //head = [18,6,10,3]
        ListNode listNode4 = new ListNode(3, null);
        ListNode listNode3 = new ListNode(10, listNode4);
        ListNode listNode2 = new ListNode(6, listNode3);
        ListNode listNode1 = new ListNode(18, listNode2);
        ListNode listNode = insertGreatestCommonDivisors(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result=head;
        while (head.next!=null){
            ListNode next = head.next;
            int headValue = head.val;
            int nextValue = next.val;
            int comFactor = calComFactor(headValue, nextValue);
            head.next=new ListNode(comFactor, next);
            head=next;

        }
        return result;
    }

    public static int calComFactor(int a,int b){
        while (a!=b) {
            if (a>b) {
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }
}
