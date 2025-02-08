package No_1_200.No141环形链表;

public class MySolution {
    public static void main(String[] args) {
        // 创建链表的头节点
        ListNode head = new ListNode(3);

        // 创建第二个节点，并将其链接到头节点
        ListNode second = new ListNode(2);
        head.next = second;

        // 创建第三个节点，并将其链接到第二个节点
        ListNode third = new ListNode(0);
        second.next = third;

        // 创建第四个节点，并将其链接到第三个节点
        ListNode fourth = new ListNode(-4);
        third.next = fourth;
        fourth.next = second;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        while (head.next != null) {
            if (head.val == Math.pow(10, 5) + 1) {
                return true;
            } else {
                head.val = (int) Math.pow(10, 5) + 1;
            }
            head = head.next;
        }
        return false;
    }
}
