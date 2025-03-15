package No_1_200.No148排序链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MySolution {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> nodes = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }
        nodes.sort(Comparator.comparingInt(node -> node.val));
        head = nodes.get(0);
        nodes.get(nodes.size() - 1).next = null;
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return head;

    }
}
