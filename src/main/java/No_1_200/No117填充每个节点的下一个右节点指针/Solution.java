package No_1_200.No117填充每个节点的下一个右节点指针;

public class Solution {

    public static void main(String[] args) {
        Node root = initNode();
        Node result = connect(root);
        System.out.println("1");
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        con(root);
        return root;
    }

    private static void con(Node node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        //要连接的节点
        Node toCon;
        //连接左节点
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            toCon = node.right;
        } else if (node.left != null) {
            toCon = node.left;
        } else {
            toCon = node.right;
        }

        //遍历的节点
        Node find = node;
        //目标next节点
        Node next = null;
        while (find.next != null) {
            Node next1 = find.next;
            if (next1.left != null) {
                next = next1.left;
                break;
            }
            if (next1.right != null) {
                next = next1.right;
                break;
            }
            if (next1.next != null) {
                find = next1.next;
            } else {
                break;
            }
        }
        toCon.next = next;
        con(node.left);
        con(node.right);
    }


    private static Node initNode() {
        //[1,2,3,4,5,null,6,7,null,null,null,null,8]
        //[1,#,2,3,#,4,5,6,#,7,8,#]
        Node node8 = new Node(8, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node6= new Node(6, null, node8, null);
        Node node4 = new Node(4, node7, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node6, null);
        return new Node(1, node2, node3, null);
    }
}
