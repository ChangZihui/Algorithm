package No_1001_2000.No1038从二叉搜索树到更大和树;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, treeNode8);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, treeNode5, treeNode7);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode0 = new TreeNode(0, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode2);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode6);
        TreeNode treeNode = bstToGst(treeNode4);
        System.out.println(1);
    }


    public static TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        visit(root, sum);
        return root;
    }

    public static int visit(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = visit(node.right, sum);
        node.val = node.val + sum;
        sum = visit(node.left, node.val);
        return sum;
    }
}
