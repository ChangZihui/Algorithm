package No_401_1000.No938二叉搜索树的范围和;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val>high) return rangeSumBST(root.left,low,high);
        if (root.val<low) return rangeSumBST(root.right,low,high);
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
//        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) +
//                root.val >= low && root.val <= high ? root.val : 0;

    }

}
