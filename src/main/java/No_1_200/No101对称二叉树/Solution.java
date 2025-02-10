package No_1_200.No101对称二叉树;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(6);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = e;
        b.left = f;
        b.right = d;
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.right = root.right;
        root.right = null;
        return isSame(root, treeNode);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left);
        }
        return false;
    }

}
