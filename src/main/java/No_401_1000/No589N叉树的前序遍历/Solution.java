package No_401_1000.No589N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3, List.of(node5, node6));
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node1 = new Node(1, List.of(node3, node2, node4));
        List<Integer> list = preorder(node1);
        for (Integer i : list) {
            System.out.print(i + ",");
        }
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> integers = new ArrayList<>();
        dfs(root, integers);
        return integers;
    }

    public static void dfs(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.children == null) return;
        for (Node child : node.children) {
            dfs(child, list);
        }
    }
}
