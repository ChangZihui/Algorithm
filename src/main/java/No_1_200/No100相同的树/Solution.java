package No_1_200.No100相同的树;

public class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        root1.left = a;
        root1.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        TreeNode root2 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        TreeNode c2 = new TreeNode(4);
        TreeNode d2 = new TreeNode(5);
        TreeNode e2 = new TreeNode(7);
        root2.left = a2;
        root2.right = b2;
        a2.left = c2;
        a2.right = d2;
        b2.left = e2;
        boolean sameTree = isSameTree(root1, root2);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

}
