package No_2001_2500.No2415反转二叉树的奇数层;

public class Solution {

    public static void main(String[] args) {
        //2,3,5,8,13,21,34
        TreeNode treeNode6 = new TreeNode(34, null, null);
        TreeNode treeNode5 = new TreeNode(21, null, null);
        TreeNode treeNode4 = new TreeNode(13, null, null);
        TreeNode treeNode3 = new TreeNode(8, null, null);
        TreeNode treeNode1 = new TreeNode(3, treeNode3, treeNode4);
        TreeNode treeNode2 = new TreeNode(5, treeNode5, treeNode6);
        TreeNode treeNode = new TreeNode(2, treeNode1, treeNode2);
        TreeNode result = reverseOddLevels(treeNode);
        System.out.println("1");
    }

    public static TreeNode reverseOddLevels(TreeNode root) {


        return null;
    }
}
