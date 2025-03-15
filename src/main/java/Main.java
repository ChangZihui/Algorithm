public class Main {
    public static void main(String[] args) {
        String word1 = "babad", word2 = "aaaa";
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode vhead = new ListNode(0, head);
        ListNode before = vhead;
        while (before.next != null && before.next.next != null) {
            ListNode swap1 = before.next;
            ListNode swap2 = swap1.next;
            ListNode after = swap2.next;
            // 交换
            before.next = swap2;
            swap2.next = swap1;
            swap1.next = after;
            before = swap1;
        }
        return vhead.next;
    }
}
