package No_1_200.No106从中序与后序遍历序列构造二叉树;

public class Solution {

    public static void main(String[] args) {
        int[] inorder = {1,2,3,4}, postorder = {4,3,2,1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(0);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 2, root);
        return root;
    }

    public static void build(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2, TreeNode parent) {
        int index = -1;
        for (int i = s1; i <= e1; i++) {
            if (parent.val == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftLength = index - s1;
        int rightLength = e1 - index;

        if (leftLength == 0) parent.left = null;
        if (leftLength == 1) parent.left = new TreeNode(inorder[s1]);

        if (rightLength == 0) parent.right = null;
        if (rightLength == 1) parent.right = new TreeNode(inorder[e1]);

        if (leftLength > 1) {
            parent.left = new TreeNode(postorder[s2 + leftLength - 1]);
            build(inorder, s1, s1 + leftLength - 1, postorder, s2, s2 + leftLength - 2, parent.left);
        }
        if (rightLength > 1) {
            parent.right = new TreeNode(postorder[e2]);
            build(inorder, index + 1, e1, postorder, e2 - rightLength + 1, e2-1, parent.right);
        }
    }
}
