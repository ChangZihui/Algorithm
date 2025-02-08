package No_1_200.No138随机链表的复制;

import java.util.HashMap;
import java.util.Map;

public class MySolution {
    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        Node node = copyRandomList(node0);
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }

    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node newHead = new Node(head.val);
        Node point = head;
        Node newPoint = newHead;
        nodeMap.put(head, newHead);
        while (point.next != null) {
            Node newNode = new Node(point.next.val);
            nodeMap.put(point.next, newNode);
            newPoint.next = newNode;
            newPoint = newNode;
            point = point.next;
        }
        point = head;
        newPoint = newHead;
        while (point != null) {
            if (point.random != null) {
                newPoint.random = nodeMap.get(point.random);
            }
            point = point.next;
            newPoint = newPoint.next;
        }

        return newHead;
    }
}
